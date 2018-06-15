program Registro;

{$APPTYPE CONSOLE}

uses
  SysUtils;

Type
        PersonCalifs = array [1..5] of Real;
        PersonRecords = Record
                Name : String[32];
                LastName : String[64];
                Age : Integer;
                Sex : String; {M- Masculino, F-Femenino}
                Calif : PersonCalifs;
                end;
  var
        PCalifs : PersonCalifs;
        Precord : PersonRecords;

begin
  PCalifs[1] :=6.7;
  PCalifs[2] :=8.5;
  PCalifs[3] :=8.5;
  PCalifs[4] :=8.9;
  PCalifs[5] :=7.2;

  Precord.Name     :='Benito';
  Precord.LastName :='Camelo';
  Precord.Age      := 20;
  Precord.Sex      :=' a diario';
  Precord.Calif    :=PCalifs;

  WriteLn('Nombre:',#9,#9, Precord.Name);
  WriteLn('Apellidos:',#9, Precord.LastName);
  WriteLn('Edad:',#9,#9, Precord.Age);
  WriteLn('Sexo:',#9,#9, Precord.Sex,#13#10);
  WriteLn('Calificaciones:',#13#10);
  WriteLn(Precord.Calif[1]);
  WriteLn(Precord.Calif[2]);
  WriteLn(Precord.Calif[3]);
  WriteLn(Precord.Calif[4]);
  WriteLn(Precord.Calif[5]);

  ReadLn


end.
