/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.apache.log4j.Logger;

/**
 *
 * @author EZIO AUDITORY
 */
public class BackupAndRestoreModel {

    static Logger logger = Logger.getLogger(BackupAndRestoreModel.class.getName());

    public String backup(String backupPath) {
        String msg = null;
        Process p = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            p = runtime.exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe --host=localhost --port=3307 -uroot -pass34 --add-drop-database -B pamunuwila_hardware_salesdepartment_db -r" + backupPath);
            logger.debug(p);
            
            int processComplete = p.waitFor();
            if (processComplete == 0) {
                msg = "Backup Successful";
            } else {
                msg = "Backup Error !";
            }
            logger.debug("Set msg");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Exception: " + e.getMessage());
        }
        logger.debug("return msg");
        return msg;
    }

    public String restore(String restorePath) {
        String msg = null;
        String dbUserName = "root";
        String dbPassword = "ass34";

        String[] restoreCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql.exe", "--host=localhost", "--port=3307", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + restorePath};
        logger.debug(restoreCmd);

        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(restoreCmd);
            int processComplete = runtimeProcess.waitFor();
            System.out.println(processComplete);
            if (processComplete == 0) {
                msg = "Restore Successful";
            } else {
                msg = "Restore Error !";
            }
            logger.debug("Set msg");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Exception: " + ex.getMessage());
        }
        logger.debug("return msg");
        return msg;
    }

}
