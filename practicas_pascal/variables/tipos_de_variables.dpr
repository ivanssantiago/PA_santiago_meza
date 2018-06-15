program tipos_de_variables;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var
CharA :Char;
CharB :Char;
Flag_1 :Boolean;
Flag_2 :Boolean;
StrName :String[5];
StrLastName :String;
StrNewName : String[30];
begin
  CharA :='A';
  CharB :='B';
  WriteLn('CharA contiene ',CharA);
  WriteLn('CharB contiene ',CharB);
  CharA :=CharB;
  CharB :=#65;
  WriteLn('CharA contiene ',CharA);
  WriteLn('CharB contiene ',CharB);

  Flag_1 := FALSE;
  Flag_2 :=not Flag_1;
  WriteLn('Flag_1 es ',Flag_1);
  WriteLn('Flag_2 es ',Flag_2);
  WriteLn('Flag_1 or Flag_2 es ',Flag_1 or Flag_2);
  WriteLn('Flag_1 and Flag_2 es ',Flag_1 and Flag_2);

  StrName :='Susan';
  StrLastName := 'Vega Cadena';
  StrNewName := 'Angelica';

  WriteLn('Nombre: ',StrName);
  WriteLn('Apellidos: ',StrLastName);
  StrName := StrNewName;
  WriteLn('Nombre: ',StrName);
  WriteLn('Apellidos: ',StrLastName);
  ReadLn

end.
