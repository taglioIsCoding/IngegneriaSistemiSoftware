%====================================================================================
% wolf_detection_local description   
%====================================================================================
request( manage_sonar, manage_sonar(STARTSTOP) ).
dispatch( update, update(N) ).
dispatch( update, far(N) ).
dispatch( manage_red_led, accendi(N) ).
%====================================================================================
context(wolfdetectionlocal, "localhost",  "TCP", "8000").
 qactor( stazione, wolfdetectionlocal, "it.unibo.stazione.Stazione").
 static(stazione).
  qactor( sonar, wolfdetectionlocal, "it.unibo.sonar.Sonar").
 static(sonar).
  qactor( sensor, wolfdetectionlocal, "it.unibo.sensor.Sensor").
 static(sensor).
