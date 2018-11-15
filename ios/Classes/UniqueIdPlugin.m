#import "UniqueIdPlugin.h"

@implementation UniqueIdPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {


 FlutterMethodChannel *fChannel = [FlutterMethodChannel methodChannelWithName:@"unique_id" binaryMessenger:registrar.messenger];

 [registrar addMethodCallDelegate:[[UniqueIdPlugin alloc] init] channel:fChannel];


}

- (void)handleMethodCall:(FlutterMethodCall *)call result:(FlutterResult)result{
    result([[UIDevice.currentDevice identifierForVendor] UUIDString]);
}
@end
