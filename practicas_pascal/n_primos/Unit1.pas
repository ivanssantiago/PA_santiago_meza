unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    PrimeList: TListBox;
    Min: TEdit;
    Max: TEdit;
    Button1: TButton;
    procedure Button1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}


procedure TForm1.Button1Click(Sender: TObject);
var
  Low,High,Count,Count2  = Integer;
begin
PrimeList.Items.Clear;
Low := strtoint (Min.Text);
High := strtoint (Max.Text);
for Count := Low to High do
begin
        Count2 :=2;
        while(Count2<count)and not (Count mod Count2 = 0) do
                inc(Count2);
        if (Count=Count2) then
                PrimeList.Items.Add(inttostr(Count))   ;
end;
end;

end.
 