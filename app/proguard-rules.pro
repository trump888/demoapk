# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#
#-dontwarn org.codehaus.**
#-keep class org.codehaus.** {*;}
#-keep interface com.haima.hmcp.listeners.*{*;}
#-keep class com.haima.hmcp.beans.*{*;}
#-keep enum com.haima.hmcp.enums.*{*;}
#-keep class com.haima.hmcp.**{*;}
#-keep enum com.haima.hmcp.websocket.WebSocketCloseNotification{*;}
#-keep interface com.haima.hmcp.websocket.WebSocket{*;}
#-keep interface com.haima.hmcp.websocket.WebSocketConnectionObserver{*;}
#-keep class com.haima.hmcp.websocket.WebSocketConnection{public <methods>;}
#-keep class com.haima.hmcp.websocket.WebSocketOptions{public <methods>;}
#-keep class com.haima.hmcp.websocket.WebSocketException{*;}
#-keep interface com.hmcp.saas.sdk.listeners.*{*;}
#-keep class com.hmcp.saas.sdk.beans.*{*;}
#-keep class com.hmcp.saas.sdk.enums.*{*;}
#-keep class com.hmcp.saas.sdk.SaasSDK{public <methods>;}
#-keep class de.tavendo.autobahn.**{*;}
#-keep class tv.haima.ijk.media.player.** { *; }
#-keep interface tv.haima.ijk.media.player.listeners.*{*;}
#-keep interface tv.haima.ijk.media.player.IMediaPlayer{*;}
#
#-keep class com.netease.LDNetDiagnoService.LDNetDiagnoService{public <methods>;}
#-keep interface com.netease.LDNetDiagnoService.LDNetDiagnoListener{public <methods>;}
#-keep class com.netease.LDNetDiagnoService.LDNetTraceRoute { *; }
#
#-dontwarn org.openudid.**
#-keep class org.openudid.**{*;}