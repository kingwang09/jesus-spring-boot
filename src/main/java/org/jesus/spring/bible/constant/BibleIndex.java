package org.jesus.spring.bible.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BibleIndex {
    //구약: The Old Testament of the King James Version of the Bible
    genesis("창", "창세기","The First Book of Moses: Called Genesis"),
    exodus("출", "출애굽기","The Second Book of Moses: Called Exodus"),
    leviticus("레", "레위기","The Third Book of Moses: Called Leviticus"),
    numbers("민", "민수기","The Fourth Book of Moses: Called Numbers"),
    deuteronomy("","" ,"The Fifth Book of Moses: Called Deuteronomy"),
    joshua("","" ,"The Book of Joshua"),
    judges("","" ,"The Book of Judges"),
    ruth("","" ,"The Book of Ruth"),
    samuel1("","" ,"The First Book of Samuel"),
    samuel2("","" ,"The Second Book of Samuel"),
    kings1("","" ,"The First Book of the Kings"),
    kings2("","" ,"The Second Book of the Kings"),
    chronicles1("","" ,"The First Book of the Chronicles"),
    Chronicles2("","" ,"The Second Book of the Chronicles"),
    ezra("","" ,"Ezra"),
    nehemiah("","" ,"The Book of Nehemiah"),
    esther("","" ,"The Book of Esther"),
    job("","" ,"The Book of Job"),
    psalms("","" ,"The Book of Psalms"),
    proverbs("","" ,"The Proverbs"),
    ecclesiastes("","" ,"Ecclesiastes"),
    solomon("","" ,"The Song of Solomon"),
    isaiah("","" ,"The Book of the Prophet Isaiah"),
    jeremiah("","" ,"The Book of the Prophet Jeremiah"),
    jeremiah_lamentations("","" ,"The Lamentations of Jeremiah"),
    ezekiel("","" ,"The Book of the Prophet Ezekiel"),
    daniel("","" ,"The Book of Daniel"),
    hosea("","" ,"Hosea"),
    joel("","" ,"Joel"),
    amos("","" ,"Amos"),
    obadiah("","" ,"Obadiah"),
    jonah("","" ,"Jonah"),
    micah("","" ,"Micah"),
    nahum("","" ,"Nahum"),
    habakkuk("","" ,"Habakkuk"),
    zephaniah("","" ,"Zephaniah"),
    haggai("","" ,"Haggai"),
    zechariah("","" ,"Zechariah"),
    malachi("","" ,"Malachi"),

    //신약: The New Testament of the King James Bible
    matthew("","" ,"The Gospel According to Saint Matthew"),
    mark("","" ,"The Gospel According to Saint Mark"),
    luke("","" ,"The Gospel According to Saint Luke"),
    john("","" ,"The Gospel According to Saint John"),
    apostles("","" ,"The Acts of the Apostles"),
    romans("","" ,"The Epistle of Paul the Apostle to the Romans"),
    corinthians1("","" ,"The First Epistle of Paul the Apostle to the Corinthians"),
    corinthians2("","" ,"The Second Epistle of Paul the Apostle to the Corinthians"),
    galatians("","" ,"The Epistle of Paul the Apostle to the Galatians"),
    ephesians("","" ,"The Epistle of Paul the Apostle to the Ephesians"),
    philippians("","" ,"The Epistle of Paul the Apostle to the Philippians"),
    colossians("","" ,"The Epistle of Paul the Apostle to the Colossians"),
    thessalonians1("","" ,"The First Epistle of Paul the Apostle to the Thessalonians"),
    thessalonians2("","" ,"The Second Epistle of Paul the Apostle to the Thessalonians"),
    timothy1("","" ,"The First Epistle of Paul the Apostle to Timothy"),
    timothy2("","" ,"The Second Epistle of Paul the Apostle to Timothy"),
    titus("","" ,"The Epistle of Paul the Apostle to Titus"),
    philemon("","" ,"The Epistle of Paul the Apostle to Philemon"),
    hebrews("","" ,"The Epistle of Paul the Apostle to the Hebrews"),
    james("","" ,"The General Epistle of James"),
    peter1("","" ,"The First Epistle General of Peter"),
    peter2("","" ,"The Second General Epistle of Peter"),
    john1("","" ,"The First Epistle General of John"),
    john2("","" ,"The Second Epistle General of John"),
    john3("","" ,"The Third Epistle General of John"),
    jude("","" ,"The General Epistle of Jude"),
    divine("","" ,"The Revelation of Saint John the Divine");

    private String koreanShortIndex;
    private String koreanIndex;
    private String description;
    //english shortIndex;
    //마지막 chapter
}
