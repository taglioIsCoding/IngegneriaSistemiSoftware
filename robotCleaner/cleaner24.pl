%====================================================================================
% cleaner24 description   
%====================================================================================
dispatch( stepdone, stepdone(V) ). %automessaggio
dispatch( stepfail, stepfail(X) ). %automessaggio
dispatch( alt, alt(N) ).
%====================================================================================
context(ctxcleaner24, "localhost",  "TCP", "8032").
 qactor( cleaner24, ctxcleaner24, "it.unibo.cleaner24.Cleaner24").
 static(cleaner24).
  qactor( alt_emitter, ctxcleaner24, "it.unibo.alt_emitter.Alt_emitter").
 static(alt_emitter).
