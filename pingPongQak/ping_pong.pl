%====================================================================================
% ping_pong description   
%====================================================================================
dispatch( hit, hit(NUM_GAME) ). %Dispactch che rappresenta il colpo di racchetta
%====================================================================================
context(ctxpingpong, "localhost",  "TCP", "8000").
 qactor( ping, ctxpingpong, "it.unibo.ping.Ping").
 static(ping).
  qactor( pong, ctxpingpong, "it.unibo.pong.Pong").
 static(pong).
