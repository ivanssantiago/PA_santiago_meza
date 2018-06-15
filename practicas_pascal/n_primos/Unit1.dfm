object Form1: TForm1
  Left = 203
  Top = 144
  Width = 870
  Height = 500
  Caption = 'Form1'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object PrimeList: TListBox
    Left = 368
    Top = 88
    Width = 177
    Height = 225
    ItemHeight = 13
    TabOrder = 0
  end
  object Min: TEdit
    Left = 208
    Top = 88
    Width = 121
    Height = 21
    TabOrder = 1
  end
  object Max: TEdit
    Left = 216
    Top = 144
    Width = 121
    Height = 21
    TabOrder = 2
  end
  object Button1: TButton
    Left = 160
    Top = 232
    Width = 155
    Height = 25
    Caption = 'Encontrar Primos'
    TabOrder = 3
    OnClick = Button1Click
  end
end
