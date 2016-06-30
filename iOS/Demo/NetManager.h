//
//  NetManager.h
//  Demo
//
//  Created by 阿凡树 on 16/6/24.
//  Copyright © 2016年 ManGang. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "AFFApiInterface.h"


typedef void (^FinishBlockWithObject)(NSError *error, id resultObject);

@interface NetManager : NSObject
+ (instancetype)sharedInstance;
- (NSURLSessionDataTask *)requestWithPath:(NSString *)path
                               parameters:(NSDictionary *)parameters
                               completion:(FinishBlockWithObject)completionBlock;
@end
