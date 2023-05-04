package jp.co.intra_mart.anotation.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.co.intra_mart.anotation.dao.UsrDao;
import jp.co.intra_mart.anotation.entity.Usr;

/**
 * <h3>[MirageSQLサンプルのメインクラス]</h3><br>
 * <br>
 * MirageSQLサンプルのMain処理を持つクラス。
 *
 * @author tarosa0001
 */
public class SampleMirageSQLBasic {
    /** ロガー */
    private static Logger logger = LogManager.getLogger(SampleMirageSQLBasic.class);

    /**
     * <h3>[Main処理]</h3><br>
     * <br>
     * MirageSQLサンプルのMain処理。<br>
     * @param args コマンド引数
     */
    public static void main(String[] args) {
        logger.info("Main処理開始");

        // データアクセスオブジェクト生成
        UsrDao dao = new UsrDao();

        // -------------------------------------------------------------
        // 検索処理呼び出し
        // -------------------------------------------------------------
        Long maxUno = dao.selectMaxUsr();

        // -------------------------------------------------------------
        // 挿入理呼び出し
        // -------------------------------------------------------------
        if (maxUno != null) {
        	maxUno = maxUno + 1;
        	dao.insertUsr(maxUno);
        }

        // -------------------------------------------------------------
        // 更新処理呼び出し
        // -------------------------------------------------------------
        Usr usr = dao.selectUsrByKey(new Long(1000));
        
        Map<String, Object> params = new HashMap<>();
        // パラメータは検索同様に設定
        params.put("uno", usr.getuNo());
        params.put("age", 300);
        dao.updateUsr(params);

        logger.info("Main処理終了");
    }
}
