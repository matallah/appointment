package sbs.security;

/**
 * @author Muhammed.Atallah
 */
public enum RolesEnum {
    SUPERADMIN,//ALL PAGES
    ADMIN,//ALL PAGES
    TEACHER,//ALL PAGES EXPECT USERS AND FEEDS
    ACCOUNTANT,//ONLY FEEDS AND TRANSACTIONS LIKE INCOME AND OUTGOING
    RECEPTIONIST,//ONLY REPORTS
    LIBRARIAN,//ONLY LIBRARY
    PARENT,//ATTENDANT AND FEEDS AND EXAMS AND LIST OF HIS CHILD'S
    STUDENT//EXAMS AND ATTENDANT AND LIBRARY
}
