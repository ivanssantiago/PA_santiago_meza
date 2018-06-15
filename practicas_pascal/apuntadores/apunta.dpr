program apunta;

{$APPTYPE CONSOLE}

uses
  SysUtils;

type
  RealPointer = ^Real;
  persontype = record
  LastName : String;
  end;
  PersonPointer =^PersonType;

  var
  P: RealPointer;
  Person : PersonPointer;


begin
 New (P);
 p^ :=21234.65;
 WriteLn('STR_1 ',P^ :5:1,' STR_2');
 Dispose(P);  {sirve para liberar memoria}
 New(Person);
 Person^.LastName :='Smith';
 WriteLn(Person^.LastName);
 dispose(Person);
 ReadLn
end.
 