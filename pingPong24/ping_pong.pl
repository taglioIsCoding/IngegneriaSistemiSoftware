%====================================================================================
% ping_pong description   
%====================================================================================
dispatch( ball, ball(NUM_GAME) ). %Dispactch che rappresenta il colpo di racchetta
dispatch( update, update(STR,N) ).
request( info_test, info_test(X) ). %sent by the testUnit to the observer
%====================================================================================
context(ctxpingpong, "localhost",  "TCP", "8000").
 qactor( ping, ctxpingpong, "it.unibo.ping.Ping").
 static(ping).
  qactor( pong, ctxpingpong, "it.unibo.pong.Pong").
 static(pong).
  qactor( referee, ctxpingpong, "it.unibo.referee.Referee").
 static(referee).
