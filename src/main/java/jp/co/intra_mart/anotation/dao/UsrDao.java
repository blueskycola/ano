package jp.co.intra_mart.anotation.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.miragesql.miragesql.ClasspathSqlResource;
import com.miragesql.miragesql.SqlManager;
import com.miragesql.miragesql.SqlResource;
import com.miragesql.miragesql.session.Session;
import com.miragesql.miragesql.session.SessionFactory;

import jp.co.intra_mart.anotation.entity.Usr;

/**
 * <h3>[ユーザーテーブルアクセスクラス]</h3><br>
 * <br>
 * ユーザーテーブルに対する操作を行うクラス。
 * @author tarosa0001
 */
public class UsrDao {
    /** ロガー */
    private Logger logger = LogManager.getLogger(UsrDao.class);

    /**
     * <h3>[ユーザーテーブル検索処理]</h3><br>
     * <br>
     * ユーザーテーブルを検索する。
     */
    public void selectUsr() {
        logger.info("ユーザーテーブル検索処理開始");

        // -------------------------------------------------------------
        // セッションオブジェクトの生成。
        // MirageSQLのクラスメソッドを使ってインスタンスを取得する
        // -------------------------------------------------------------
        Session session = SessionFactory.getSession();
        SqlManager sqlManager = session.getSqlManager();

        // -------------------------------------------------------------
        // セッションの開始
        // Springと連携する方法もある
        // -------------------------------------------------------------
        session.begin();
        try {
            // -------------------------------------------------------------
            // SQLによるレコード検索の開始
            // MirageSQLの機能を使用してSQLのリソースを生成
            // -------------------------------------------------------------
            SqlResource selecttUsrSql = new ClasspathSqlResource("sql/SelectUsr.sql");

            // -------------------------------------------------------------
            // 検索条件のパラメータを生成
            // ここでは社員番号を指定
            // パラメータは数値であろうとも文字列として指定する
            // -------------------------------------------------------------
            Map<String, Object> params = new HashMap<>();
            params.put("uno", 9000);

            // -------------------------------------------------------------
            // SQLをリソースとして生成し、パラメータはMapとして引き渡す。
            // -------------------------------------------------------------
            Usr usr = sqlManager.getSingleResult(Usr.class, selecttUsrSql, params);

            // --------------------------------------------
            // 検索結果を出力
            // --------------------------------------------
            System.out.println(usr);
            System.out.println("--------------------------------------------");

            // -------------------------------------------------------------
            // 次はパラメータにユーザー名に設定
            // -------------------------------------------------------------
            params = new HashMap<>();
            params.put("uname", "%TARO");

            // -------------------------------------------------------------
            // ユーザー名はlike検索なので複数の結果を取得
            // -------------------------------------------------------------
            List<Usr> result = sqlManager.getResultList(Usr.class, selecttUsrSql, params);

            // -------------------------------------------------------------
            // 検索結果を全件出力
            // -------------------------------------------------------------
            result.forEach(li -> System.out.println(li));
            System.out.println("--------------------------------------------");

            // -------------------------------------------------------------
            // パラメータなしで全件検索
            // -------------------------------------------------------------
            result = sqlManager.getResultList(Usr.class, selecttUsrSql);

            // -------------------------------------------------------------
            // 検索結果を全件出力
            // -------------------------------------------------------------
            result.forEach(li -> System.out.println(li));

            // --------------------------------------------
            // セッションをコミット
            // --------------------------------------------
            session.commit();
        } catch(Exception e) {
            logger.error("DB系のエラー", e);

            // エラーの場合はロールバック
            session.rollback();
        } finally {
            // セッションは必ずリリースする
            session.release();
        }

        logger.info("ユーザーテーブル検索処理終了");
    }
    

    /**
     * <h3>[ユーザーテーブル検索処理]</h3><br>
     * <br>
     * ユーザーテーブルを検索する。
     */
    public Usr selectUsrByKey(Long uno) {
    	Usr usr = null;
        logger.info("ユーザーテーブル検索処理開始");

        // -------------------------------------------------------------
        // セッションオブジェクトの生成。
        // MirageSQLのクラスメソッドを使ってインスタンスを取得する
        // -------------------------------------------------------------
        Session session = SessionFactory.getSession();
        SqlManager sqlManager = session.getSqlManager();

        // -------------------------------------------------------------
        // セッションの開始
        // Springと連携する方法もある
        // -------------------------------------------------------------
        session.begin();
        try {
            // -------------------------------------------------------------
            // SQLによるレコード検索の開始
            // MirageSQLの機能を使用してSQLのリソースを生成
            // -------------------------------------------------------------
            SqlResource selecttUsrSql = new ClasspathSqlResource("sql/SelectUsr.sql");

            // -------------------------------------------------------------
            // 検索条件のパラメータを生成
            // ここでは社員番号を指定
            // パラメータは数値であろうとも文字列として指定する
            // -------------------------------------------------------------
            Map<String, Object> params = new HashMap<>();
            params.put("uno", uno);

            // -------------------------------------------------------------
            // SQLをリソースとして生成し、パラメータはMapとして引き渡す。
            // -------------------------------------------------------------
            usr = sqlManager.getSingleResult(Usr.class, selecttUsrSql, params);

            // --------------------------------------------
            // 検索結果を出力
            // --------------------------------------------
            System.out.println("selectUsrByKey--------------------------------------------");
            System.out.println(usr);
            System.out.println("--------------------------------------------");


            // --------------------------------------------
            // セッションをコミット
            // --------------------------------------------
            session.commit();
        } catch(Exception e) {
            logger.error("DB系のエラー", e);

            // エラーの場合はロールバック
            session.rollback();
        } finally {
            // セッションは必ずリリースする
            session.release();
        }

        logger.info("ユーザーテーブル検索処理終了");
        return usr;
    }
    

    /**
     * <h3>[ユーザーテーブル検索処理]</h3><br>
     * <br>
     * ユーザーテーブルを検索する。
     */
    public Long selectMaxUsr() {
    	Long result = null;
        logger.info("ユーザーテーブル最大UNO検索処理開始");

        // -------------------------------------------------------------
        // セッションオブジェクトの生成。
        // MirageSQLのクラスメソッドを使ってインスタンスを取得する
        // -------------------------------------------------------------
        Session session = SessionFactory.getSession();
        SqlManager sqlManager = session.getSqlManager();

        // -------------------------------------------------------------
        // セッションの開始
        // Springと連携する方法もある
        // -------------------------------------------------------------
        session.begin();
        try {
            // -------------------------------------------------------------
            // SQLによるレコード検索の開始
            // MirageSQLの機能を使用してSQLのリソースを生成
            // -------------------------------------------------------------
            SqlResource selecttUsrSql = new ClasspathSqlResource("sql/SelectMaxUsr.sql");

            // -------------------------------------------------------------
            // 検索条件のパラメータを生成
            // ここでは社員番号を指定
            // パラメータは数値であろうとも文字列として指定する
            // -------------------------------------------------------------
            //Map<String, Object> params = new HashMap<>();
            // -------------------------------------------------------------
            // SQLをリソースとして生成し、パラメータはMapとして引き渡す。
            // -------------------------------------------------------------
            //Usr usr = sqlManager.getSingleResult(Usr.class, selecttUsrSql);
            result = sqlManager.getSingleResult(Long.class, selecttUsrSql);

            // --------------------------------------------
            // 検索結果を出力
            // --------------------------------------------
            System.out.println("ユーザーテーブル最大UNO検索処理開始--------------------------------------------");
            System.out.println(result);
            System.out.println("--------------------------------------------");

            // --------------------------------------------
            // セッションをコミット
            // --------------------------------------------
            session.commit();
        } catch(Exception e) {
            logger.error("DB系のエラー", e);

            // エラーの場合はロールバック
            session.rollback();
        } finally {
            // セッションは必ずリリースする
            session.release();
        }
        logger.info("ユーザーテーブル検索処理終了");

        return result;
    }

    /**
     * <h3>[ユーザーテーブル挿入処理]</h3><br>
     * <br>
     * ユーザーテーブルにレコードを挿入する。
     */
    public void insertUsr(Long uno) {
        logger.info("ユーザーテーブル挿入処理開始");

        Session session = SessionFactory.getSession();

        // セッション開始
        session.begin();
        try {
            // ------------------------------------------------------------
            // INSERTするレコードのエンティティを生成
            // SQLではなくMirageSQLのメソッドを使用してINSERTする。
            // ------------------------------------------------------------
//            Usr usr = new Usr(new Long(1000), "test01", new Double(0),
//                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        	Usr usr = new Usr(uno, "test01", new Double(0), new Date());
            SqlManager sqlManager = session.getSqlManager();
            int result = sqlManager.insertEntity(usr);
            System.out.println("エンティティで挿入した件数挿入件数：" + result);

            // ------------------------------------------------------------
            // SQLを使ってINSERTする
            // MirageSQLではINSERTのSQLを発行する機能はなく、
            // 更新用のメソッドを使ってINSERTする。
            // ------------------------------------------------------------
            Map<String, Object> params = new HashMap<>();
            // パラメータは検索同様に設定
            params.put("uno", uno + 1);
            SqlResource insertUsrSql = new ClasspathSqlResource("sql/insertUsr.sql");
            result = session.getSqlManager().executeUpdate(insertUsrSql, params);
            System.out.println("SQLで挿入した件数挿入件数：" + result);

            session.commit();
        } catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.release();
        }

        logger.info("ユーザーテーブル挿入処理終了");
    }

    /**
     * <h3>[ユーザーテーブル更新処理]</h3><br>
     * <br>
     * ユーザーテーブルのレコードを更新する。
     */
    public void updateUsr(Map<String, Object> params) {
        logger.info("ユーザーテーブル更新処理開始");

        Session session = SessionFactory.getSession();

        // セッション開始
        session.begin();

        try {
            // ------------------------------------------------------------
            // UPDATEするレコードのエンティティを生成
            // SQLではなくMirageSQLのメソッドを使用してINSERTする。
            // ------------------------------------------------------------
//            Usr usr = new Usr(new Long(1001), "test01", new Double(99), new Date());
//            SqlManager sqlManager = session.getSqlManager();
//            int result = sqlManager.updateEntity(usr);
//            System.out.println("更新件数：" + result);

            // ------------------------------------------------------------
            // SQLを使ってUPDATEする
            // MirageSQLではINSERTのSQLを発行する機能はなく、
            // 検索用のメソッドを使ってINSERTする。
            // ------------------------------------------------------------
            
            SqlResource updateUsrSql = new ClasspathSqlResource("sql/updateUsr.sql");
            int result = session.getSqlManager().executeUpdate(updateUsrSql, params);
            System.out.println("更新件数：" + result);

            session.commit();
        } catch(Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.release();
        }

        logger.info("社員テーブル更新処理終了");
    }
}
