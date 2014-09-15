■batch.zip
→　バッチ処理＝package batch　のソースフォルダです。
　
　日経株の指定銘柄情報収集（スクレイピング）処理と
　お好みのRSSフィードから情報を収集する処理です。
　また収集した情報を任意のフォーマットに変更し
　所定のサーバにFTP転送する処理実行します。
　C:\Users\yatabe\workspace\batch\src\batch　に配置しています。
--------------------------------------------------------
■hogehoge.zip
→　オンライン処理＝package hogehoge.com　のソースフォルダです。
　WEB/APサーバ（Apache×Tomcat想定）上で動作するオンラインアプリケーションです。
　C:\Users\yatabe\workspacehogehoge\src\hogehoge\com　に配置しています。

--------------------------------------------------------　
★オンラインAPで1点環境設定をお願い致します。

TomcatのデフォルトルートからC:\tmp配下のファイルを参照する目的で
シンボリックリンクをはっています。
・C:\Users\yatabe\workspace\hogehoge\WebContent\data　 と、C:\tmp\data
・C:\Users\yatabe\workspace\hogehoge\WebContent\kanshi と、C:\tmp\kanshi

 (シンボリックリンクコマンド）
管理者権限で起動したコマンドプロンプトから実行します。Unixと間逆です！ご注意。

mklink /D C:\tmp\data   C:\Users\yatabe\workspace\hogehoge\WebContent\data 
mklink /D C:\tmp\kanshi C:\Users\yatabe\workspace\hogehoge\WebContent\kanshi 

■data.zip（WebSocketサーバに連携するファイル）
サンプルファイルが入っています。

■kanshi.zip(監視サーバから連携されてくる画像ファイル）
サンプルファイルが入っています。

--------------------------------------------------------
★Libraryの件

両パッケージとも、参照するLibraryは同じです。
プログラム一覧の「３．Jarファイル一覧シート」のjarにPATHを通して下さい。
プロジェクタサンプル以外ですと以下が追加分です。
　・sqlite-jdbc-3.7.2.jar
　・log4j-1.2.8.jar
　・jtidy-r938.jar
--------------------------------------------------------
■pub.zip
→　プロパティファイルのzipです。
　　C:\pub\batch に配置願います。

　　IPアドレス等の可変設定や、カスタマイズ仕様は全て外出しです。
--------------------------------------------------------
■tmp.zip
→C:\tmp に配置願います。

Runtime.getRuntime().exec("c:/tmp/test.bat")として
プロジェクタミラーリング処理をバッチ起動します。

[test.bat] →　環境にあわせて変更をお願い致します。

cd C:\Documents and Settings\yatabe\workspace\hogehoge\build\classes
call java hogehoge.com.sample.TestMain
pause

--------------------------------------------------------　　


