��batch.zip
���@�o�b�`������package batch�@�̃\�[�X�t�H���_�ł��B
�@
�@���o���̎w����������W�i�X�N���C�s���O�j������
�@���D�݂�RSS�t�B�[�h����������W���鏈���ł��B
�@�܂����W��������C�ӂ̃t�H�[�}�b�g�ɕύX��
�@����̃T�[�o��FTP�]�����鏈�����s���܂��B
�@C:\Users\yatabe\workspace\batch\src\batch�@�ɔz�u���Ă��܂��B
--------------------------------------------------------
��hogehoge.zip
���@�I�����C��������package hogehoge.com�@�̃\�[�X�t�H���_�ł��B
�@WEB/AP�T�[�o�iApache�~Tomcat�z��j��œ��삷��I�����C���A�v���P�[�V�����ł��B
�@C:\Users\yatabe\workspacehogehoge\src\hogehoge\com�@�ɔz�u���Ă��܂��B

--------------------------------------------------------�@
���I�����C��AP��1�_���ݒ�����肢�v���܂��B

Tomcat�̃f�t�H���g���[�g����C:\tmp�z���̃t�@�C�����Q�Ƃ���ړI��
�V���{���b�N�����N���͂��Ă��܂��B
�EC:\Users\yatabe\workspace\hogehoge\WebContent\data�@ �ƁAC:\tmp\data
�EC:\Users\yatabe\workspace\hogehoge\WebContent\kanshi �ƁAC:\tmp\kanshi

 (�V���{���b�N�����N�R�}���h�j
�Ǘ��Ҍ����ŋN�������R�}���h�v�����v�g������s���܂��BUnix�Ɗԋt�ł��I�����ӁB

mklink /D C:\tmp\data   C:\Users\yatabe\workspace\hogehoge\WebContent\data 
mklink /D C:\tmp\kanshi C:\Users\yatabe\workspace\hogehoge\WebContent\kanshi 

��data.zip�iWebSocket�T�[�o�ɘA�g����t�@�C���j
�T���v���t�@�C���������Ă��܂��B

��kanshi.zip(�Ď��T�[�o����A�g����Ă���摜�t�@�C���j
�T���v���t�@�C���������Ă��܂��B

--------------------------------------------------------
��Library�̌�

���p�b�P�[�W�Ƃ��A�Q�Ƃ���Library�͓����ł��B
�v���O�����ꗗ�́u�R�DJar�t�@�C���ꗗ�V�[�g�v��jar��PATH��ʂ��ĉ������B
�v���W�F�N�^�T���v���ȊO�ł��ƈȉ����ǉ����ł��B
�@�Esqlite-jdbc-3.7.2.jar
�@�Elog4j-1.2.8.jar
�@�Ejtidy-r938.jar
--------------------------------------------------------
��pub.zip
���@�v���p�e�B�t�@�C����zip�ł��B
�@�@C:\pub\batch �ɔz�u�肢�܂��B

�@�@IP�A�h���X���̉ϐݒ��A�J�X�^�}�C�Y�d�l�͑S�ĊO�o���ł��B
--------------------------------------------------------
��tmp.zip
��C:\tmp �ɔz�u�肢�܂��B

Runtime.getRuntime().exec("c:/tmp/test.bat")�Ƃ���
�v���W�F�N�^�~���[�����O�������o�b�`�N�����܂��B

[test.bat] ���@���ɂ��킹�ĕύX�����肢�v���܂��B

cd C:\Documents and Settings\yatabe\workspace\hogehoge\build\classes
call java hogehoge.com.sample.TestMain
pause

--------------------------------------------------------�@�@


