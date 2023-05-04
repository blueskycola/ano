package jp.co.intra_mart.anotation.entity;


import java.util.Date;

import com.miragesql.miragesql.annotation.Column;
import com.miragesql.miragesql.annotation.PrimaryKey;
import com.miragesql.miragesql.annotation.PrimaryKey.GenerationType;

/**
 * <h3>[ユーザーテーブルエンティティ]</h3><br>
 * <br>
 * DBの列とフィールドの対応はアノテーションを使って対応させる。
 * @author tarosa0001
 */
public class Usr {
    /** ユーザー番号 */
    @PrimaryKey(generationType = GenerationType.APPLICATION)
    @Column(name = "UNO")
    private Long uNo;

    /** ユーザー名 */
    @Column(name = "UNAME")
    private String uName;

    /** 年齢 */
    @Column(name = "AGE")
    private Double age;

    /** 誕生日 */
    @Column(name = "BDATE")
    private Date bDate;

    /**
     * <h3>[コンストラクタ]</h3><br>
     * <br>
     * 引数を使用してユーザーエンティティのフィールドを設定する。
     * @param uNo ユーザー番号
     * @param uName ユーザー名
     * @param age 年齢
     * @param date 誕生日
     */
    public Usr(Long uNo, String uName, Double age, java.util.Date date) {
        this.uNo = uNo;
        this.uName = uName;
        this.age = age;
        this.bDate = date;
    }

    /**
     * <h3>[ユーザー番号取得処理]</h3><br>
     * ユーザー番号を取得します。<br>
     * @return uNo ユーザー番号
     */
    public Long getuNo() {
        return uNo;
    }

    /**
     * <h3>[ユーザー番号設定処理]</h3><br>
     * ユーザー番号を設定します。<br>
     * @param uNo ユーザー番号
     */
    public void setuNo(Long uNo) {
        this.uNo = uNo;
    }

    /**
     * <h3>[ユーザー名取得処理]</h3><br>
     * ユーザー名を取得します。<br>
     * @return uName ユーザー名
     */
    public String getuName() {
        return uName;
    }

    /**
     * <h3>[ユーザー名設定処理]</h3><br>
     * ユーザー名を設定します。<br>
     * @param uName ユーザー名
     */
    public void setuName(String uName) {
        this.uName = uName;
    }

    /**
     * <h3>[年齢取得処理]</h3><br>
     * 年齢を取得します。<br>
     * @return age 年齢
     */
    public Double getAge() {
        return age;
    }

    /**
     * <h3>[年齢設定処理]</h3><br>
     * 年齢を設定します。<br>
     * @param age 年齢
     */
    public void setAge(Double age) {
        this.age = age;
    }

    /**
     * <h3>[誕生日取得処理]</h3><br>
     * 誕生日を取得します。<br>
     * @return bDate 誕生日
     */
    public Date getbDate() {
        return bDate;
    }

    /**
     * <h3>[誕生日設定処理]</h3><br>
     * 誕生日を設定します。<br>
     * @param bDate 誕生日
     */
    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        // 文字列表現組み立て
        StringBuilder sb = new StringBuilder();
        sb.append(this.uNo);
        sb.append(", ");
        sb.append(this.uName);
        sb.append(", ");
        sb.append(this.age);
        sb.append(", ");
        sb.append(this.bDate);

        return new String(sb);
    }
}
