SQLLite�̔z�u�ꏊ��ύX�����ꍇ

��DB��C:\JAVA_HOME\sqlLite �z���ɔz�u����z��ł��B

�����z�u���ύX�����ꍇ�́A���萔�ł����ȉ������ҏW�肢�܂��B

package hogehoge.com.db.KjdbcConnect.java

44�s�ڂ�sqlLite�̕����I�Ȕz�u�ݒ���L�q���Ă��܂��B

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
            Connection procConect = DriverManager.getConnection("jdbc:sqlite:C:/JAVA_HOME/sqlLite/ex1"); //<<----�R�R

            //�I�[�g�R�~�b�g���~�߂�
            procConect.setAutoCommit(false);

