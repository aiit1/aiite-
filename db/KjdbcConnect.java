package hogehoge.com.db;
//import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;
/****************************************************************************
*
* JDBC�x�[�X�N���X.
*
* @author  kaeru
* @version 1.0 27 April 2013
* 
***************************************************************************/

public class KjdbcConnect {
    /** DB�X�e�[�g�����g */
    private Statement dbStm = null;
    /** JDBC�ڑ� */
    private Connection dbConnect = null;
    /** DB�R�l�N�V�������� */
    private String strConnectTime = null;

    
    /**************************************************************************
     * �R���X�g���N�^.
     * �f�[�^�x�[�X�̃R�l�N�g��ێ�����B
     *
     * @param dbConnect �R�l�N�g 
     **************************************************************************/
    public KjdbcConnect(Connection dbConnect) {
        this.dbConnect = dbConnect;
    }
    
    /**************************************************************************
     * sqLite�p
     * @param   String strGroupId   �O���[�vID�����炤
     * @param   String strBusiness  �Ɩ�ID�����炤
     * @throws Exception
     */
    public KjdbcConnect( String strGroupId, String strBusiness) throws Exception {
        try { 
            Class.forName("org.sqlite.JDBC");

            //�f�[�^�x�[�X�ւ̐ڑ����擾����
            Connection procConect = DriverManager.getConnection("jdbc:sqlite:C:/JAVA_HOME/sqlLite/ex1");

            //�I�[�g�R�~�b�g���~�߂�
            procConect.setAutoCommit(false);

            //�R�l�N�V������ێ�
            this.dbConnect = procConect;
            
            //�R�l�N�V�������쐬�������Ԃ��擾����
            this.setConnectTime();

            System.out.println(" :: NttifJdbcConnect() �O���[�vID :: " + strGroupId + " :: �Ɩ�ID :: " + strBusiness + " :: DB�R�l�N�V�����I�[�v�� :: "+this.getConnectTime());
        } catch (MissingResourceException ex) {
            throw new Exception(this.getClass().getName() + " :: �v���p�e�B�t�@�C�����R�l�N�V�����擾���̎擾���s :: " + ex.toString());
        } catch (SQLException ex) {
            throw new Exception(this.getClass().getName() + " :: �R�l�N�V�����擾���s :: " + ex.toString());
        } catch (Exception e) {
            throw new Exception(this.getClass().getName() + " :: �h���C�o�̃C���X�^���X�擾�����Ŏ��s���܂����B :: " + e.toString());
        }
    }
    public Connection getConnection() {
        //cat.debug("NttifJdbcConnect:java.sql.Connection��ԋp" + this.getConnectTime());
        return this.dbConnect;
    }
    /**
     * �c�a�R�l�N�V�����擾�����ݒ�.
     * �c�a�R�l�N�V�����擾���Ԃ��C���X�^���X�ϐ��Ɋi�[����B
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
     * �X�e�[�g�����g�N���[�Y.
     *
     * @exception SQLException SQL�G���[
     * @exception LifeplanException
     **************************************************************************/
    public void statmentClose() throws SQLException, Exception {
        try {
            if (dbStm != null) {
                dbStm.close();
                dbStm = null;
            }
        } catch (SQLException ex) {
            //cat.info(this.getClass().getName() + " :: statmentClose() :: �G���[�ł͂���܂���B�X�e�[�g�����g�����łɃN���[�Y����Ă��� :: " + ex.toString(), ex);
            //�X�e�[�g�����g�����łɃN���[�Y����Ă��邩���`�F�b�N����֐����񋟂���Ă��Ȃ��̂�Exception�ŃL���b�`���Ĉ���Ԃ��B
            //          throw new LifeplanException(this.getClass().getName() + " :: statmentClose() :: �X�e�[�g�����g�N���[�Y���s :: " + ex.toString(), LifeplanException.DBMS);
        }
    }
    /**************************************************************************
     * COMMIT���s.
     *
     * @exception SQLException SQL�G���[
     * @exception LifeplanException
     **************************************************************************/
    public void commit() throws SQLException, Exception {
        try {
            // �R�~�b�g���s
            dbConnect.commit();
            //cat.debug("NttifJdbcConnect:�R�~�b�g���s" + this.getConnectTime());
        } catch (SQLException ex) {
            //throw new LifeplanException("�R�~�b�g���s���s:" + ex.toString(), LifeplanException.DBMS);
        }
    }
    /**************************************************************************
     * Rollback���s.
     *
     * @exception SQLException SQL�G���[
     * @exception LifeplanException
     **************************************************************************/
    public void rollback() throws SQLException, Exception {
        try {
            // ���[���o�b�N���s
            dbConnect.rollback();
            //cat.debug("NttifJdbcConnect:���[���o�b�N���s" + this.getConnectTime());
        } catch (SQLException ex) {
            //throw new LifeplanException("���[���o�b�N���s:" + ex.toString(), LifeplanException.DBMS);
        }

    }
    public void close() throws Exception {
        try {
            this.statmentClose();

            //�R�l�N�V������null�ȊO�ł܂��R�l�N�V�������N���[�Y����Ă��Ȃ����`�F�b�N����
            if (dbConnect != null && !dbConnect.isClosed()) {
                // �N���[�Y���s
                dbConnect.close();
            }

            //cat.info(this.getClass().getName() + " :: close() DB�R�l�N�V�����N���[�Y :: " + this.getConnectTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        	//cat.info(this.getClass().getName() + " :: close() �G���[�ł͂���܂���BDB�R�l�N�V���������łɃN���[�Y����Ă��� :: �R�l�N�g�^�C�� :: " + this.getConnectTime() + " :: " + ex.toString(), ex);
            //throw new LifeplanException(this.getClass().getName() + " :: �f�[�^�x�[�X�N���[�Y���s :: " + ex.toString(), LifeplanException.DBMS);
        }
    }

    /**
     * �c�a�R�l�N�V�����擾�����擾
     * @return DB�R�l�N�V�����擾����
     */
    public String getConnectTime() {
        String ret = strConnectTime;
        if (ret == null) {
            ret = "Not Connectid";
        }
        return ret;
    }

}
