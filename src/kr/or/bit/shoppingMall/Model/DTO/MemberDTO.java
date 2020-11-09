package kr.or.bit.shoppingMall.Model.DTO;

public class MemberDTO {

    //    CREATE TABLE memberTest (
//	id VARCHAR2(20) NOT NULL, /* 유저 아이디 */
//    pwd VARCHAR2(30) NOT NULL, /* 비번 */
//    name VARCHAR2(20) NOT NULL, /* 이름 */
//    hp CHAR(13), /* 폰 */
//    delflag CHAR(1) DEFAULT 'N' NOT NULL, /* 탈퇴여부 */
//    card_num VARCHAR2(20), /* 카드번호 */
//    address VARCHAR2(50) /* 주소 */
//     );
    private String id;
    private String pwd;
    private String name;
    private String hp;
    private String delflag;
    private String card_num;
    private String address;

    public MemberDTO () {}

    public MemberDTO (String id,String pwd, String name, String hp, String delflag, String card_num, String address) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.hp = hp;
        this.delflag = delflag;
        this.card_num = card_num;
        this. address = address;
    }
    //signUp DTO
    public MemberDTO (String id,String pwd, String name, String hp, String card_num, String address) {
        super();
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.hp = hp;
        this.card_num = card_num;
        this. address = address;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", delflag='" + delflag + '\'' +
                ", card_num='" + card_num + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
