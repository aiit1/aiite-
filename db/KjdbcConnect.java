package hogehoge.com.db;
//import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
/****************************************************************************
*
* JDBCベースクラス.
*
* @author  kaeru
* @version 1.0 27 April 2013
* 
***************************************************************************/

public class KjdbcConnect {
    /** DBステートメント */
    private Statement dbStm = null;
    /** JDBC接続 */
    private Connection dbConnect = null;
    /** DBコネクション時間 */
    private String strConnectTime = null;

    
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
            Connection procConect = DriverManager.getConnection("jdbc:sqlite:C:/JAVA_HOME/sqlLite/ex1");

            //オートコミットを止める
            procConect.setAutoCommit(false);

            //コネクションを保持
            this.dbConnect = procConect;
            
            //コネクションを作成した時間を取得する
            this.setConnectTime();

            System.out.println(" :: NttifJdbcConnect() グループID :: " + strGroupId + " :: 業務ID :: " + strBusiness + " :: DBコネクションオープン :: "+this.getConnectTime());
        } catch (MissingResourceException ex) {
            throw new Exception(this.getClass().getName() + " :: プロパティファイルよりコネクション取得情報の取得失敗 :: " + ex.toString());
        } catch (SQLException ex) {
            throw new Exception(this.getClass().getName() + " :: コネクション取得失敗 :: " + ex.toString());
        } catch (Exception e) {
            throw new Exception(this.getClass().getName() + " :: ドライバのインスタンス取得処理で失敗しました。 :: " + e.toString());
        }
    }
    public Connection getConnection() {
        //cat.debug("NttifJdbcConnect:java.sql.Connectionを返却" + this.getConnectTime());
        return this.dbConnect;
    }
    /**
     * ＤＢコネクション取得時刻設定.
     * ＤＢコネクション取得時間をインスタンス変数に格納する。
     */
    private void setConnectTime() {
        strConnectTime = null;
        Calendar cal = new GregorianCalendar();
        StringBuffer sb = new StringBuffer();
        sb.append(" TIME[");
        sb.append(cal.get(Calendar.YEAR));
        if (cal.get(Calendar.MONTH) + 1 < 10) {
            sb.append("0");
            sb.append(cal.get(Calendar.MONTH) + 1);
        } else {
            sb.append(cal.get(Calendar.MONTH) + 1);
        }

        if (cal.get(Calendar.DATE) < 10) {
            sb.append("0");
            sb.append(cal.get(Calendar.DATE));
        } else {
            sb.append(cal.get(Calendar.DATE));
        }

        if (cal.get(Calendar.HOUR) < 10) {
            sb.append("0");
            sb.append(cal.get(Calendar.HOUR));
        } else {
            sb.append(cal.get(Calendar.HOUR));
        }

        if (cal.get(Calendar.MINUTE) < 10) {
            sb.append("0");
            sb.append(cal.get(Calendar.MINUTE));
        } else {
            sb.append(cal.get(Calendar.MINUTE));
        }

        if (cal.get(Calendar.SECOND) < 10) {
            sb.append("0");
            sb.append(cal.get(Calendar.SECOND));
        } else {
            sb.append(cal.get(Calendar.SECOND));
        }

        if (cal.get(Calendar.MILLISECOND) < 10) {
            sb.append("00");
            sb.append(cal.get(Calendar.MILLISECOND));
        } else if (cal.get(Calendar.MILLISECOND) < 100) {
            sb.append("0");
            sb.append(cal.get(Calendar.MILLISECOND));
        } else {
            sb.append(cal.get(Calendar.MILLISECOND));
        }
        sb.append("]");
        strConnectTime = sb.toString();
    }

    /**************************************************************************
     * ステートメントクローズ.
     *
     * @exception SQLException SQLエラー
     * @exception LifeplanException
     **************************************************************************/
    public void statmentClose() throws SQLException, Exception {
        try {
            if (dbStm != null) {
                dbStm.close();
                dbStm = null;
            }
        } catch (SQLException ex) {
            //cat.info(this.getClass().getName() + " :: statmentClose() :: エラーではありません。ステートメントがすでにクローズされている :: " + ex.toString(), ex);
            //ステートメントがすでにクローズされているかをチェックする関数が提供されていないのでExceptionでキャッチして握りつぶす。
            //          throw new LifeplanException(this.getClass().getName() + " :: statmentClose() :: ステートメントクローズ失敗 :: " + ex.toString(), LifeplanException.DBMS);
        }
    }
    /**************************************************************************
     * COMMIT実行.
     *
     * @exception SQLException SQLエラー
     * @exception LifeplanException
     **************************************************************************/
    public void commit() throws SQLException, Exception {
        try {
            // コミット実行
            dbConnect.commit();
            //cat.debug("NttifJdbcConnect:コミット実行" + this.getConnectTime());
        } catch (SQLException ex) {
            //throw new LifeplanException("コミット失敗失敗:" + ex.toString(), LifeplanException.DBMS);
        }
    }
    /**************************************************************************
     * Rollback実行.
     *
     * @exception SQLException SQLエラー
     * @exception LifeplanException
     **************************************************************************/
    public void rollback() throws SQLException, Exception {
        try {
            // ロールバック実行
            dbConnect.rollback();
            //cat.debug("NttifJdbcConnect:ロールバック実行" + this.getConnectTime());
        } catch (SQLException ex) {
            //throw new LifeplanException("ロールバック失敗:" + ex.toString(), LifeplanException.DBMS);
        }

    }
    public void close() throws Exception {
        try {
            this.statmentClose();

            //コネクションがnull以外でまだコネクションがクローズされていないかチェックする
            if (dbConnect != null && !dbConnect.isClosed()) {
                // クローズ実行
                dbConnect.close();
            }

            //cat.info(this.getClass().getName() + " :: close() DBコネクションクローズ :: " + this.getConnectTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        	//cat.info(this.getClass().getName() + " :: close() エラーではありません。DBコネクションがすでにクローズされている :: コネクトタイム :: " + this.getConnectTime() + " :: " + ex.toString(), ex);
            //throw new LifeplanException(this.getClass().getName() + " :: データベースクローズ失敗 :: " + ex.toString(), LifeplanException.DBMS);
        }
    }

    /**
     * ＤＢコネクション取得時刻取得
     * @return DBコネクション取得時間
     */
    public String getConnectTime() {
        String ret = strConnectTime;
        if (ret == null) {
            ret = "Not Connectid";
        }
        return ret;
    }

}
