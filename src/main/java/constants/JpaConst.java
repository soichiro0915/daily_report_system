package constants;

/**
 * DB関連の項目値を定義するインターフェース
 * ※インターフェイスに定義した変数は public static final 修飾子がついているとみなされる
 */
public interface JpaConst {
	//persistence-unit名
	String PERSISTENCE_UNIT_NAME = "daily_report_system";

	//データ取得件数の最大値
	int ROW_PER_PAGE = 15;

	//従業員テーブル
	String TABLE_EMP = "employees";
	//従業員テーブルカラム
	String EMP_COL_ID = "id"; //id
	String EMP_COL_CODE = "code"; //社員番号
	String EMP_COL_NAME = "name"; //氏名
	String EMP_COL_PASS = "password"; //password
	String EMP_COL_ADMIN_FLAG = "admin_falg"; //管理者権限の有無
	String EMP_COL_CREATED_AT = "created_at";
	String EMP_COL_UPDATED_AT = "updated_at";
	String EMP_COL_DELETE_FALG = "delete_flag"; //削除フラグ

	int ROLE_ADMIN = 1; //管理者権限ON(管理者)
    int ROLE_GENERAL = 0; //管理者権限OFF(一般)
    int EMP_DEL_TRUE = 1; //削除フラグON(削除済み)
    int EMP_DEL_FALSE = 0; //削除フラグOFF(現役)

    //日報テーブル
    String TABLE_REP = "reports"; //テーブル名
    //日報テーブルカラム
    String REP_COL_ID = "id";
    String REP_COL_EMP = "employee_id";
    String REP_COL_REP_DATe = "report_date";
    String REP_TITLE = "title";
    String REP_CONTENT = "content";
    String REP_COL_CREATED_AT = "created_at";
    String REP_COL_UPDATED_AT = "updated_at";

    //Entity名
    String ENTITY_EMP = "employee";
    String ENTITY_REP = "report";

    //JPQL内のパラメータ
    String JPQL_PARM_CODE = "code"; //社員番号
    String JPQL_PARM_PASSWORD = "password";
    String JPQL_PARM_EMPLOYEE = "employee";

    //NamedQueryのnameとquery
    //すべての従業員をidの降順で取得する
    String Q_EMP_GET_ALL = ENTITY_EMP + ".getALL"; //name
    String Q_EMP_GETALL_DEF = "select e from Employee As e order by e.id desc"; //query
    //すべての従業員の件数を取得する
    String Q_EMP_COUNT = ENTITY_EMP + ".count";
    String Q_EMP_COUNT_DEF = "select count(e) from Employee as e";
    //社員番号とハッシュ化済みパスワードを条件に未削除の従業員を取得する
    String Q_EMP_GET_BY_CODE_AND_PASS = ENTITY_EMP + ".getByCodePass";
    String Q_EMP_GET_BY_CODE_AND_PASS_DEF = "select e from Employee as e where e.deleteFlag = 0 and e.code = :" + JPQL_PARM_CODE + " AND e.password = :" + JPQL_PARM_PASSWORD;
    //指定した社員番号を保持する従業員の件数を取得する
    String Q_EMP_COUNT_RESISTERED_BY_CODE = ENTITY_EMP + ".countRegisteredByCode";
    String Q_EMP_COUNT_RESISTERED_BY_CODE_DEF = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :" + JPQL_PARM_CODE;
    //全ての日報をidの降順に取得する
    String Q_REP_GET_ALL = ENTITY_REP + ".getAll";
    String Q_REP_GET_ALL_DEF = "SELECT r FROM Report AS r ORDER BY r.id DESC";
    //全ての日報の件数を取得する
    String Q_REP_COUNT = ENTITY_REP + ".count";
    String Q_REP_COUNT_DEF = "SELECT COUNT(r) FROM Report AS r";
    //指定した従業員が作成した日報を全件idの降順で取得する
    String Q_REP_GET_ALL_MINE = ENTITY_REP + ".getAllMine";
    String Q_REP_GET_ALL_MINE_DEF = "SELECT r FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";
    //指定した従業員が作成した日報の件数を取得する
    String Q_REP_COUNT_ALL_MINE = ENTITY_REP + ".countAllMine";
    String Q_REP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;
}
