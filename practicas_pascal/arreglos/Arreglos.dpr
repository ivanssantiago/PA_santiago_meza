program Arreglos;

{$APPTYPE CONSOLE}

uses
  SysUtils;

{
        int IntArray[5]; //ejemplo en c
  }
type MyRealArrayType= array [1..3] of Real;
     MyOtherArrayType= array[5..7] of Integer;
     MyTicTacToeType= array[1..3,1..3] of Char;
var
MyRealArray : MyRealArrayType;
MyIntArray  : MyOtherArrayType;
MyBidimArray: MyTicTacToeType;

begin
  MyRealArray[1] := 3.14;
  MyRealArray[2] := 1.41 ;
  MyRealArray[3] := 2.69;

  WriteLn(MyRealArray[1]);
  WriteLn(MyRealArray[2]);
  WriteLn(MyRealArray[3],#13#10);

  MyIntArray[5] :=100;
  MyIntArray[6] :=200;
  MyIntArray[7] :=300;

  WriteLn(MyIntArray[5]);
  WriteLn(MyIntArray[6]);
  WriteLn(MyIntArray[7],#13#10);

  MyBidimArray[1,1] :='X';
  MyBidimArray[2,1] :='O';
  MyBidimArray[2,2] :='X';
  MyBidimArray[3,1] :='O';
  MyBidimArray[3,2]  :='O';
  MyBidimArray[3,3]  :='X';

  WriteLn(MyBidimArray[1,1],' ',MyBidimArray[3,1]);
  WriteLn(' ',MyBidimArray[2,2],' ');
  WriteLn(MyBidimArray[3,1],' ',MyBidimArray[3,3]);


  ReadLn

end.
