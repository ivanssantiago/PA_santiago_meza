program Project1;

{$APPTYPE CONSOLE}

uses
  SysUtils;

(*Se puede tener comentarios tambìén de esta forma*)

  const
  TaxRate=0.28;
  var GrossPay :Single;
  var ExtraPay : Single;
  var NetTotalPay :Single;
  var NetPay : Single;

begin
  GrossPay := 100.0;
  ExtraPay := 50.55;
  NetTotalPay := GrossPay+ExtraPay;
  NetPay := NetTotalPay-(NetTotalPay*TaxRate);
  Writeln ('pago final $',NetPay);
  readLn {Unicamente para que la ventana se cierre hasta oprimir enter}
end.
 