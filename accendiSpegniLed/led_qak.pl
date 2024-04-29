%====================================================================================
% led_qak description   
%====================================================================================
dispatch( led_cmd, manage_led(STARTSTOP) ).
%====================================================================================
context(ctxled, "localhost",  "TCP", "8001").
 qactor( led_usage, ctxled, "it.unibo.led_usage.Led_usage").
 static(led_usage).
  qactor( sender, ctxled, "it.unibo.sender.Sender").
 static(sender).
