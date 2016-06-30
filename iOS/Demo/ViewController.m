//
//  ViewController.m
//  Demo
//
//  Created by 阿凡树 on 16/6/24.
//  Copyright © 2016年 ManGang. All rights reserved.
//

#import "ViewController.h"
#import "NetManager.h"
@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    [[NetManager sharedInstance] requestWithPath:Home_Index parameters:nil completion:^(NSError *error, id resultObject) {
        if (error == nil) {
            NSLog(@"%@",resultObject);
        }
        else{
            NSLog(@"error = %@",error);
        }
    }];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
