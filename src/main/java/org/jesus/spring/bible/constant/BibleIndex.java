package org.jesus.spring.bible.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BibleIndex {
    //구약: The Old Testament of the King James Version of the Bible
    genesis("창", "창세기","Ge", "The First Book of Moses: Called Genesis"),
    exodus("출", "출애굽기","Exo","The Second Book of Moses: Called Exodus"),
    leviticus("레", "레위기","Lev", "The Third Book of Moses: Called Leviticus"),
    numbers("민", "민수기","Num", "The Fourth Book of Moses: Called Numbers"),
    deuteronomy("신","신명" ,"Deu", "The Fifth Book of Moses: Called Deuteronomy"),
    joshua("수","여호수아" ,"Josh","The Book of Joshua"),
    judges("삿","사사기" ,"Jdgs","The Book of Judges"),
    ruth("룻","룻기" ,"Ruth","The Book of Ruth"),
    samuel1("삼상","사무엘상" ,"1Sm","The First Book of Samuel"),
    samuel2("삼하","사무엘하" ,"2Sm","The Second Book of Samuel"),
    kings1("왕상","열왕기상" ,"1Ki","The First Book of the Kings"),
    kings2("왕하","열왕기하" ,"2Ki","The Second Book of the Kings"),
    chronicles1("대상","역대상" ,"1Chr","The First Book of the Chronicles"),
    Chronicles2("대하","역대하" ,"2Chr","The Second Book of the Chronicles"),
    ezra("스","에스라" ,"Ezra","Ezra"),
    nehemiah("느","느헤미야" ,"Neh","The Book of Nehemiah"),
    esther("에","에스더" ,"Est","The Book of Esther"),
    job("욥","욥기" ,"Job","The Book of Job"),
    psalms("시","시편" ,"Psa","The Book of Psalms"),
    proverbs("잠","잠언" ,"Prv","The Proverbs"),
    ecclesiastes("전","전도서" ,"Eccl","Ecclesiastes"),
    solomon("아","아가" ,"SSol","The Song of Solomon"),
    isaiah("사","이사야" ,"Isa","The Book of the Prophet Isaiah"),
    jeremiah("렘","예레미야" ,"Jer","The Book of the Prophet Jeremiah"),
    jeremiah_lamentations("애","예레미야 애가" ,"Lam","The Lamentations of Jeremiah"),
    ezekiel("겔","에스겔" ,"Eze","The Book of the Prophet Ezekiel"),
    daniel("단","다니엘" ,"Dan","The Book of Daniel"),
    hosea("호","호세아" ,"Hos","Hosea"),
    joel("욜","요엘" ,"Joe","Joel"),
    amos("암","아모스" ,"Amos","Amos"),
    obadiah("옵","오베다" ,"Obad","Obadiah"),
    jonah("욘","요나" ,"Jonah","Jonah"),
    micah("미","미가" ,"Mic","Micah"),
    nahum("나","나훔" ,"Nahum","Nahum"),
    habakkuk("합","하박국" ,"Hab","Habakkuk"),
    zephaniah("습","스바랴" ,"Zep","Zephaniah"),
    haggai("학","학기" ,"Hag","Haggai"),
    zechariah("슥","스가랴" ,"Zec","Zechariah"),
    malachi("말","말라기" ,"Mal","Malachi"),

    //신약: The New Testament of the King James Bible
    matthew("마","마태복음" ,"Mat","The Gospel According to Saint Matthew"),
    mark("막","마가복음" ,"Mark","The Gospel According to Saint Mark"),
    luke("눅","누가복음" ,"Luke","The Gospel According to Saint Luke"),
    john("요","요한복음" ,"John","The Gospel According to Saint John"),
    apostles("행","사도행전" ,"Acts","The Acts of the Apostles"),
    romans("롬","로마서" ,"Rom","The Epistle of Paul the Apostle to the Romans"),
    corinthians1("고전","고린도전서" ,"1Cor","The First Epistle of Paul the Apostle to the Corinthians"),
    corinthians2("고후","고린도후서" ,"2Cor","The Second Epistle of Paul the Apostle to the Corinthians"),
    galatians("갈","갈라디아서" ,"Gal","The Epistle of Paul the Apostle to the Galatians"),
    ephesians("엡","에베소서" ,"Eph","The Epistle of Paul the Apostle to the Ephesians"),
    philippians("빌","빌립보서" ,"Phi","The Epistle of Paul the Apostle to the Philippians"),
    colossians("골","골로새서" ,"Col","The Epistle of Paul the Apostle to the Colossians"),
    thessalonians1("살전","데살로니가전서" ,"1Th","The First Epistle of Paul the Apostle to the Thessalonians"),
    thessalonians2("살후","데살로니가후서" ,"2Th","The Second Epistle of Paul the Apostle to the Thessalonians"),
    timothy1("딤전","디모데전서" ,"1Tim","The First Epistle of Paul the Apostle to Timothy"),
    timothy2("딤후","디모데후서" ,"2Tim","The Second Epistle of Paul the Apostle to Timothy"),
    titus("딛","디도서" ,"Titus","The Epistle of Paul the Apostle to Titus"),
    philemon("몬","빌레몬서" ,"Phmn","The Epistle of Paul the Apostle to Philemon"),
    hebrews("히","히브리서" ,"Heb","The Epistle of Paul the Apostle to the Hebrews"),
    james("약","야고보서" ,"Jas","The General Epistle of James"),
    peter1("벧전","베드로전서" ,"1Pet","The First Epistle General of Peter"),
    peter2("벧후","베드로후서" ,"2Pet","The Second General Epistle of Peter"),
    john1("요일","요한일서" ,"1Jn","The First Epistle General of John"),
    john2("요이","요한이서" ,"2Jn","The Second Epistle General of John"),
    john3("요삼","요한삼서" ,"3Jn","The Third Epistle General of John"),
    jude("유","유다서" ,"Jude","The General Epistle of Jude"),
    divine("계","요한계시록" ,"Rev","The Revelation of Saint John the Divine");

    private String koreanShortIndex;
    private String koreanIndex;
    private String englishShortIndex;
    private String description;


    public static BibleIndex findByKoreanShortIndex(String koreanShortIndex){
        for(BibleIndex bibleIndex : values()){
            if(bibleIndex.getKoreanShortIndex().equals(koreanShortIndex)){
                return bibleIndex;
            }
        }
        return null;
    }

    public static BibleIndex findByEnglishShortIndex(String englishShortIndex){
        for(BibleIndex bibleIndex : values()){
            if(bibleIndex.getEnglishShortIndex().equals(englishShortIndex)){
                return bibleIndex;
            }
        }
        return null;
    }

    //마지막 chapter
}
