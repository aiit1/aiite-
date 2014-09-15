SQLLiteの配置場所を変更される場合

※DBはC:\JAVA_HOME\sqlLite 配下に配置する想定です。

もし配置先を変更される場合は、お手数ですが以下をご編集願います。

package hogehoge.com.db.KjdbcConnect.java

44行目にsqlLiteの物理的な配置設定を記述しています。

    /**************************************************************************
     * コンストラクタ.
     * データベースのコネクトを保持する。
     *
     * @param dbConnect コネクト 
     **************************************************************************/
    public KjdbcConnect(Connection dbConnect) {
        this.dbConnect = dbConnect;
    }
    
    /**************************************************************************
     * sqLite用
     * @param   String strGroupId   グループIDをもらう
     * @param   String strBusiness  業務IDをもらう
     * @throws Exception
     */
    public KjdbcConnect( String strGroupId, String strBusiness) throws Exception {
        try { 
            Class.forName("org.sqlite.JDBC");

            //データベースへの接続を取得する
            Connection procConect = DriverManager.getConnection("jdbc:sqlite:C:/JAVA_HOME/sqlLite/ex1"); //<<----ココ

            //オートコミットを止める
            procConect.setAutoCommit(false);

