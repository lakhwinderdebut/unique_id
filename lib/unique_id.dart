import 'dart:async';

import 'package:flutter/services.dart';

class UniqueId {
  static const MethodChannel _channel = const MethodChannel('unique_id');

  static Future<String> get getID async {
    final String uniqueID = await _channel.invokeMethod('getID');
    return uniqueID;
  }
}
