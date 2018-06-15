program apunta2;

{$APPTYPE CONSOLE}

uses
  SysUtils;

type
  PersonType = record
        LastName : String;
        FirstName : String;
        Age : Integer;
        end;
  PersonPointer = ^Persontype;
  var
  Person : PersonPointer;

begin
  New(Person);
  Person^.LastName := 'smith';
  Person^.FirstName := 'James';
  Person^.Age := 35;
  WriteLn('Well ',Person^.FirstName,' ',person^.LastName,', you are ',
  Person^.Age,' years old');
  dispose(Person);
  ReadLn
end.
