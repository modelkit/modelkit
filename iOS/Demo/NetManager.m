//
//  NetManager.m
//  Demo
//
//  Created by 阿凡树 on 16/6/24.
//  Copyright © 2016年 ManGang. All rights reserved.
//

#import "NetManager.h"
#import "AFNetworking.h"

@interface NetManager()
{
    AFHTTPSessionManager  *_manager;
}
@end

@implementation NetManager

+ (instancetype)sharedInstance {
    static NetManager *instance = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        instance = [[self alloc] init];
    });
    return instance;
}
- (instancetype)init {
    self = [super init];
    if (self) {
        _manager = [AFHTTPSessionManager manager];
        AFHTTPResponseSerializer* serializer = [AFHTTPResponseSerializer serializer];
        serializer.acceptableContentTypes = [NSSet setWithObjects:@"text/json",@"text/javascript",@"application/json",@"text/plain",@"text/html",@"application/xhtml+xml",@"application/xml",nil];
        _manager.responseSerializer = serializer;
    }
    return self;
}
- (NSURLSessionDataTask *)requestWithPath:(NSString *)path parameters:(NSDictionary *)parameters completion:(FinishBlockWithObject)completionBlock
{
    NSString* urlPath = [NSString stringWithFormat:@"https://raw.githubusercontent.com/modelkit/modelkit/master/api/%@.json",path];
    NSURLSessionDataTask* result = [_manager GET:urlPath parameters:parameters progress:nil success:^(NSURLSessionDataTask * _Nonnull task, id  _Nullable responseObject) {
        completionBlock(nil,[self objectFromResponse:responseObject address:path]);
    } failure:^(NSURLSessionDataTask * _Nullable task, NSError * _Nonnull error) {
        completionBlock(error,nil);
    }];
    return result;
}
- (AFFBaseApi*)objectFromResponse:(id)response address:(NSString *)url{
    NSMutableArray *urlomponents = [[url componentsSeparatedByString:@"/"] mutableCopy];
    for (int i = 0 ; i < urlomponents.count; i++) {
        urlomponents[i] = [urlomponents[i] capitalizedString];
    }
    NSString *aClassName = [NSString stringWithFormat:@"AFF%@", [urlomponents componentsJoinedByString:@""]];
    Class class = NSClassFromString(aClassName);
    NSError *error = NULL;
    id obj = [[class alloc] initWithData:response error:&error];
    if (error) {
        NSLog(@"%@", error);
    }
    return obj;
}

@end
