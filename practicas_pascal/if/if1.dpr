program if1;

{$APPTYPE CONSOLE}

uses
  SysUtils;

type
  AdressType = record
  Street : String[50];
  City : String[20];
  State : String[2];
  ZipCode :String[10];
  end;   {AdressType}

  PersonType = record
  LastName : String [20];
  FirsName : String[10];
  EmployeeNumber: Integer;
  HomeAdress : AdressType;
  WorkAdress : AdressType;
  end;   {PersonType}

  var Employee : PersonType;

begin

 with Employee do
  begin
   LastName :='Osler';
   FirsName :='Don';
   EmployeeNumber :=16253;
  end;

 with Employee.HomeAdress do
 begin
 Street :='1313 Your St.';
 City :='MyTown';
 State :='CA';
 ZipCode :='95630-0011';
 end;

  with Employee.WorkAdress do
 begin
 Street :='1313 Your St.';
 City :='MyTown';
 State :='CA';
 ZipCode :='95630-0011';
 end;

 with Employee do
 begin
        WriteLn(LastName);
        WriteLn(FirsName);
        WriteLn(EmployeeNumber);
        end;

        with employee.HomeAdress do
        begin
         WriteLn(Street);
         WriteLn(City);
         WriteLn(State);
         WriteLn(ZipCode);
        end;

         with employee.WorkAdress do
        begin
         WriteLn(Street);
         WriteLn(City);
         WriteLn(State);
         WriteLn(ZipCode);
        end;
        ReadLn


  { TODO -oUser -cConsole Main : Insert code here }
end.
