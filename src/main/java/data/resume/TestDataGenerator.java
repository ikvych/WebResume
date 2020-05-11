package data.resume;

import ikvych.resume.model.LanguageLevel;
import ikvych.resume.model.LanguageType;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class TestDataGenerator {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String JDBC_USERNAME = "postgres";
    private static final String JDBC_PASSWORD = "test";

    private static final String PHOTO_PATH = "external/photo";
    private static final String CERTIFICATES_PATH = "external/certificates";
    private static final String MEDIA_DIR = System.getProperty("user.dir") + "/src/main/webapp/media";
    private static final String COUNTRY = "UKRAINE";
    private static final String[] SITIES = {"Lviv", "Ivano-Frankivsk", "Kiyv"};
    private static final String[] FOREGIN_LANGUAGE = {"Spanish", "German", "French", "Italian"};
    private static final String PASSWORD_HASH = "$2a$10$q7732w6Rj3kZGhfDYSIXI.wFp.uwTSi2inB2rYHvm1iDIAf1J1eVq";

    private static final String[] HOBBIES = {"Cycling", "Handball", "Football", "Basketball", "Bowling", "Boxing", "Volleyball", "Baseball", "Skating", "Skiing", "Table tennis", "Tennis",
            "Weightlifting", "Automobiles", "Book reading", "Cricket", "Photo", "Shopping", "Cooking", "Codding", "Animals", "Traveling", "Movie", "Painting", "Darts", "Fishing", "Kayak slalom",
            "Games of chance", "Ice hockey", "Roller skating", "Swimming", "Diving", "Golf", "Shooting", "Rowing", "Camping", "Archery", "Pubs", "Music", "Computer games", "Authorship", "Singing",
            "Foreign lang", "Billiards", "Skateboarding", "Collecting", "Badminton", "Disco"};

    private static final List<LanguageLevel> languageLevels = new ArrayList<>(EnumSet.allOf(LanguageLevel.class));
    private static final List<LanguageType> languageTypes = new ArrayList<>(EnumSet.allOf(LanguageType.class));

    private static final String DUMMY_CONTENT_TEXT = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus. Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia. Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum. Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris. Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc. Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui. Aenean ut eros et nisl sagittis vestibulum. Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus. Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis. Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi. Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo. Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor. Donec posuere vulputate arcu. Phasellus accumsan cursus velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed aliquam, nisi quis porttitor congue, elit erat euismod orci, ac placerat dolor lectus quis orci. Phasellus consectetuer vestibulum elit. Aenean tellus metus, bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodales nec, volutpat a, suscipit non, turpis. Nullam sagittis. Suspendisse pulvinar, augue ac venenatis condimentum, sem libero volutpat nibh, nec pellentesque velit pede quis nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce id purus. Ut varius tincidunt libero. Phasellus dolor. Maecenas vestibulum mollis diam. Pellentesque ut neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In dui magna, posuere eget, vestibulum et, tempor auctor, justo. In ac felis quis tortor malesuada pretium. Pellentesque auctor neque nec urna. Proin sapien ipsum, porta a, auctor quis, euismod ut, mi. Aenean viverra rhoncus pede. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut non enim eleifend felis pretium feugiat. Vivamus quis mi. Phasellus a est. Phasellus magna. In hac habitasse platea dictumst. Curabitur at lacus ac velit ornare lobortis. Curabitur a felis in nunc fringilla tristique. Morbi mattis ullamcorper velit. Phasellus gravida semper nisi. Nullam vel sem. Pellentesque libero tortor, tincidunt et, tincidunt eget, semper nec, quam. Sed hendrerit. Morbi ac felis. Nunc egestas, augue at pellentesque laoreet, felis eros vehicula leo, at malesuada velit leo quis pede. Donec interdum, metus et hendrerit aliquet, dolor diam sagittis ligula, eget egestas libero turpis vel mi. Nunc nulla. Fusce risus nisl, viverra et, tempor et, pretium in, sapien. Donec venenatis vulputate lorem. Morbi nec metus. Phasellus blandit leo ut odio. Maecenas ullamcorper, dui et placerat feugiat, eros pede varius nisi, condimentum viverra felis nunc et lorem. Sed magna purus, fermentum eu, tincidunt eu, varius ut, felis. In auctor lobortis lacus. Quisque libero metus, condimentum nec, tempor a, commodo mollis, magna. Vestibulum ullamcorper mauris at ligula. Fusce fermentum. Nullam cursus lacinia erat. Praesent blandit laoreet nibh. Fusce convallis metus id felis luctus adipiscing. Pellentesque egestas, neque sit amet convallis pulvinar, justo nulla eleifend augue, ac auctor orci leo non est. Quisque id mi. Ut tincidunt tincidunt erat. Etiam feugiat lorem non metus. Vestibulum dapibus nunc ac augue. Curabitur vestibulum aliquam leo. Praesent egestas neque eu enim. In hac habitasse platea dictumst. Fusce a quam. Etiam ut purus mattis mauris sodales aliquam. Curabitur nisi. Quisque malesuada placerat nisl. Nam ipsum risus, rutrum vitae, vestibulum eu, molestie vel, lacus. Sed augue ipsum, egestas nec, vestibulum et, malesuada adipiscing, dui. Vestibulum facilisis, purus nec pulvinar iaculis, ligula mi congue nunc, vitae euismod ligula urna in dolor. Mauris sollicitudin fermentum libero. Praesent nonummy mi in odio. Nunc interdum lacus sit amet orci. Vestibulum rutrum, mi nec elementum vehicula, eros quam gravida nisl, id fringilla neque ante vel mi. Morbi mollis tellus ac sapien. Phasellus volutpat, metus eget egestas mollis, lacus lacus blandit dui, id egestas quam mauris ut lacus. Fusce vel dui. Sed in libero ut nibh placerat accumsan. Proin faucibus arcu quis ante. In consectetuer turpis ut velit. Nulla sit amet est. Praesent metus tellus, elementum eu, semper a, adipiscing nec, purus. Cras risus ipsum, faucibus ut, ullamcorper id, varius ac, leo. Suspendisse feugiat. Suspendisse enim turpis, dictum sed, iaculis a, condimentum nec, nisi. Praesent nec nisl a purus blandit viverra. Praesent ac massa at ligula laoreet iaculis. Nulla neque dolor, sagittis eget, iaculis quis, molestie non, velit. Mauris turpis nunc, blandit et, volutpat molestie, porta ut, ligula. Fusce pharetra convallis urna. Quisque ut nisi. Donec mi odio, faucibus at, scelerisque quis, convallis in, nisi. ";
    private static final List<String> SENTENCES;

    static {
        String[] sentences = DUMMY_CONTENT_TEXT.split("\\.");
        List<String> list = new ArrayList<>(sentences.length);
        for (String strings : sentences) {
            if (strings.length() > 0) {
                list.add(strings.trim() + ".");
            }
        }
        SENTENCES = Collections.unmodifiableList(list);
    }

    private static final Random r = new Random();
    private static int idProfile = 0;
    private static LocalDate birthDay = null;

    public static void main(String[] args) throws IOException, SQLException {
        clearMediaDIR();
        List<Profile> profiles = loadProfiles();
        List<Certificate> certificates = loadCertificate();
        List<ProfileConfig> profileConfigs = getProfileConfigs();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            connection.setAutoCommit(false);
            clearDataBase(connection);
            for (Profile profile : profiles) {
                ProfileConfig profileConfig = profileConfigs.get(r.nextInt(profileConfigs.size()));
                createProfile(connection, profile, profileConfig, certificates);
                System.out.println("Created profile for " + profile.firstName + " " + profile.lastName);
            }
            /*            insertSkillCategories(connection);*/
            connection.commit();
            System.out.println("DataBase generated successful");
        }
    }

    private static void createProfile(Connection connection, Profile profile, ProfileConfig profileConfig, List<Certificate> certificates) throws SQLException, IOException {
        insertProfileData(connection, profile, profileConfig);
        if (profileConfig.certificates > 0) {
            insertCertificates(connection, profileConfig, certificates);
        }
        insertEducation(connection);
        insertHobbies(connection);
        insertLanguages(connection);
        insertPractics(connection, profileConfig);
        insertSkills(connection, profileConfig);
        insertCourses(connection);
    }

    private static void clearMediaDIR() throws IOException {
        if (Files.exists(Paths.get(MEDIA_DIR))) {
            Files.walkFileTree(Paths.get(MEDIA_DIR), new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                    Files.delete(path);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        System.out.println("Media is clear");
    }

    private static void clearDataBase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from profile");
        /*        statement.executeUpdate("delete from skill_category");*/
        statement.executeQuery("select setval('profile_id_seq', 1, false)");
        statement.executeQuery("select setval('hobby_id_seq', 1, false)");
        statement.executeQuery("select setval('certificate_id_seq', 1, false)");
        statement.executeQuery("select setval('education_id_seq', 1, false)");
        statement.executeQuery("select setval('language_id_seq', 1, false)");
        statement.executeQuery("select setval('practical_id_seq', 1, false)");
        statement.executeQuery("select setval('skill_id_seq', 1, false)");
        statement.executeQuery("select setval('course_id_seq', 1, false)");
        System.out.println("DataBase is clear");
    }

    private static List<Profile> loadProfiles() {
        File[] photos = new File(PHOTO_PATH).listFiles();
        List<Profile> profiles = new ArrayList<>(photos.length);
        for (File file : photos) {
            String[] nameParts = file.getName().replace(".jpg", "").split(" ");
            String firstName = nameParts[0];
            String secondName = nameParts[1];
            profiles.add(new Profile(firstName, secondName, file.getAbsolutePath()));
        }
        profiles.sort(new Comparator<Profile>() {
            @Override
            public int compare(Profile o1, Profile o2) {
                int firstCompare = o1.firstName.compareTo(o2.firstName);
                if (firstCompare != 0) {
                    return firstCompare;
                } else {
                    return o1.lastName.compareTo(o2.lastName);
                }
            }
        });
        return profiles;
    }

    private static List<Certificate> loadCertificate() {
        File[] files = new File(CERTIFICATES_PATH).listFiles();
        List<Certificate> certificates = new ArrayList<>(files.length);
        for (File file : files) {
            String name = file.getName().split("\\.")[0].replace("-", " ");
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            certificates.add(new Certificate(name, file.getAbsolutePath()));
        }
        return certificates;
    }

    private static List<ProfileConfig> getProfileConfigs() {
        List<ProfileConfig> res = new ArrayList<>();
        res.add(new ProfileConfig("Junior java trainee position",
                "Java core course with developing one simple console application", new Course[]{Course.createCoreCourse()}, 0));

        res.add(new ProfileConfig("Junior java trainee position",
                "One Java professional course with developing web application blog (Link to demo is provided)",
                new Course[]{Course.createBaseCourse()}, 0));

        res.add(new ProfileConfig("Junior java developer position",
                "One Java professional course with developing web application resume (Link to demo is provided)",
                new Course[]{Course.createAdvancedCourse()}, 0));
        res.add(new ProfileConfig("Junior java developer position", "One Java professional course with developing web application resume (Link to demo is provided)",
                new Course[]{Course.createAdvancedCourse()}, 1));
        res.add(new ProfileConfig("Junior java developer position", "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
                new Course[]{Course.createAdvancedCourse(), Course.createBaseCourse()}, 1));
        res.add(new ProfileConfig("Junior java developer position", "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
                new Course[]{Course.createAdvancedCourse(), Course.createBaseCourse()}, 1));
        res.add(new ProfileConfig("Junior java developer position", "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
                new Course[]{Course.createAdvancedCourse(), Course.createBaseCourse()}, 1));
        res.add(new ProfileConfig("Junior java developer position", "Two Java professional courses with developing two web applications: blog and resume (Links to demo are provided)",
                new Course[]{Course.createAdvancedCourse(), Course.createBaseCourse()}, 2));
        res.add(new ProfileConfig("Junior java developer position",
                "Three Java professional courses with developing one console application and two web applications: blog and resume (Links to demo are provided)",
                new Course[]{Course.createAdvancedCourse(), Course.createBaseCourse(), Course.createCoreCourse()}, 2));
        return res;
    }

    private static void insertPractics(Connection connection, ProfileConfig profileConfig) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into practical values (nextval('practical_id_seq'),?,?,?,?,?,?,?,?)");
        for (Course course : profileConfig.courses) {
            preparedStatement.setString(1, course.company);
            LocalDate finish = randomFinishEducation();
            LocalDate begin = minusDate(finish, ChronoUnit.YEARS, 5, true);
            preparedStatement.setDate(2, Date.valueOf(begin));
            preparedStatement.setString(3, course.responsibilities);
            if (course.demo == null) {
                preparedStatement.setNull(4, Types.VARCHAR);
            } else {
                preparedStatement.setString(4, course.demo);
            }
            if (course.github == null) {
                preparedStatement.setNull(5, Types.VARCHAR);
            } else {
                preparedStatement.setString(5, course.github);
            }
            if (finish.isAfter(LocalDate.now())) {
                preparedStatement.setNull(6, Types.DATE);
            } else {
                preparedStatement.setDate(6, Date.valueOf(finish));
            }
            preparedStatement.setLong(7, idProfile);
            preparedStatement.setString(8, course.name);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.close();
    }

    private static void insertSkills(Connection connection, ProfileConfig profileConfig) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into skill values (nextval('skill_id_seq'),?,?,?)");
        Map<String, Set<String>> map = Course.createSkillMap();
        for (Course course : profileConfig.courses) {
            for (String key : map.keySet()) {
                map.get(key).addAll(course.skills.get(key));
            }
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty()) {

                ps.setString(1, entry.getKey());
                ps.setString(2, StringUtils.join(entry.getValue().toArray(), ","));
                ps.setLong(3, idProfile);
                ps.addBatch();
            }
        }
        ps.executeBatch();
        ps.close();
    }

    private static void insertCourses(Connection connection) throws SQLException {
        if (r.nextBoolean()) {
            PreparedStatement ps = connection.prepareStatement("insert into course values (nextval('course_id_seq'),?,?,?,?,?,?,?,?)");
            ps.setString(1, "Java Advanced Course");
            ps.setString(2, "SourceIt");
            LocalDate finish = randomFinishCourses();
            ps.setDate(3, Date.valueOf(finish));
            ps.setLong(4, idProfile);
            LocalDate begin = minusDate(finish, ChronoUnit.MONTHS, 5, true);
            ps.setDate(5, Date.valueOf(begin));
            ps.setString(6, "http://LINK_TO_DEMO");
            ps.setString(7, "http://LINK_TO_SRC");
            ps.setString(8, "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting");
            ps.executeUpdate();
            ps.close();
        }
    }

/*    private static void insertSkillCategories(Connection c) throws SQLException {
        int id = 1;
        Map<String, Set<String>> categories = Course.createSkillMap();
        PreparedStatement ps = c.prepareStatement("insert into skill_category values (?,?)");
        for (String category : categories.keySet()) {
            ps.setLong(1, id++);
            ps.setString(2, category);
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
    }*/


    private static void insertLanguages(Connection c) throws SQLException {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        if (r.nextBoolean()) {
            int cnt = r.nextInt(1) + 1;
            List<String> otherLng = new ArrayList<>(Arrays.asList(FOREGIN_LANGUAGE));
            Collections.shuffle(otherLng);
            for (int i = 0; i < cnt; i++) {
                languages.add(otherLng.remove(0));
            }
        }
        PreparedStatement ps = c.prepareStatement("insert into language values (nextval('language_id_seq'),?,?,?,?)");
        for (String language : languages) {
            LanguageType langType = languageTypes.get(r.nextInt(languageTypes.size()));
            LanguageLevel langLevel = languageLevels.get(r.nextInt(languageLevels.size()));
            ps.setString(1, language);
            ps.setString(2, langLevel.getDbValue());
            ps.setString(3, langType.getDbValue());
            ps.setLong(4, idProfile);
            ps.addBatch();
            if (langType != LanguageType.ALL) {
                ps.setString(1, language);
                LanguageLevel newLangLevel = languageLevels.get(r.nextInt(languageLevels.size()));
                while (newLangLevel == langLevel) {
                    newLangLevel = languageLevels.get(r.nextInt(languageLevels.size()));
                }
                ps.setString(2, langLevel.getDbValue());
                ps.setString(3, langType.getReversType().getDbValue());
                ps.setLong(4, idProfile);
                ps.addBatch();
            }
        }
        ps.executeBatch();
        ps.close();
    }

    private static void insertHobbies(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("insert into hobby values (nextval('hobby_id_seq'),?,?)");
        List<String> hobbies = new ArrayList<>(Arrays.asList(HOBBIES));
        Collections.shuffle(hobbies);
        for (int i = 0; i < 5; i++) {
            ps.setString(1, hobbies.remove(0));
            ps.setLong(2, idProfile);
            ps.addBatch();
        }
        ps.executeBatch();
        ps.close();
    }

    private static void insertEducation(Connection connection) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into education values (nextval('education_id_seq'),?,?,?,?,?,?)");
        preparedStatement.setString(1, "The specialist degree in Electronic Engineering");
        LocalDate finish = randomFinishEducation();
        LocalDate begin = minusDate(finish, ChronoUnit.YEARS, 5, true);
        preparedStatement.setInt(2, begin.getYear());
        if (finish.isAfter(LocalDate.now())) {
            preparedStatement.setNull(3, Types.INTEGER);
        } else {
            preparedStatement.setInt(3, finish.getYear());
        }
        preparedStatement.setString(4, "Kharkiv National Technical University, Ukraine");
        preparedStatement.setString(5, "Computer Science");
        preparedStatement.setLong(6, idProfile);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static LocalDate minusDate(LocalDate finish, ChronoUnit field, int value, boolean isBeginEducation) {
        LocalDate localDate = finish.minus(value, field);
        if (isBeginEducation) {
            localDate = LocalDate.of(localDate.getYear(), 9, 1);
        }
        return localDate;
    }

    private static LocalDate randomFinishEducation() {
        int year = birthDay.getYear() + 21;
        return LocalDate.of(year + r.nextInt(3), 7, 30);
    }

    private static LocalDate randomFinishCourses() {
        LocalDate finishCoureDate = LocalDate.now().minus(1, ChronoUnit.YEARS);
        return finishCoureDate;
    }

    private static void insertCertificates(Connection connection, ProfileConfig profileConfig, List<Certificate> certificates) throws SQLException, IOException {
        Collections.shuffle(certificates);
        PreparedStatement preparedStatement = connection.prepareStatement("insert into certificate values (nextval('certificate_id_seq'),?,?,?,?)");
        for (int i = 0; i < profileConfig.certificates && i < certificates.size(); i++) {
            Certificate certificate = certificates.get(i);
            preparedStatement.setString(1, certificate.name);
            String largeUid = UUID.randomUUID().toString() + ".jpg";
            File largePhoto = new File(MEDIA_DIR + "/certificates/" + largeUid);
            if (!largePhoto.getParentFile().exists()) {
                largePhoto.getParentFile().mkdirs();
            }
            Files.copy(Paths.get(certificate.largeImg), Paths.get(largePhoto.getAbsolutePath()));

            preparedStatement.setString(2, "/media/certificates/" + largeUid);

            String smallUid = largeUid.replace(".jpg", "-small.jpg");
            Thumbnails.of(largePhoto).size(110, 110).toFile(new File(MEDIA_DIR + "/certificates/" + smallUid));
            preparedStatement.setString(3, "media/certificates/" + smallUid);
            preparedStatement.setLong(4, idProfile);
            preparedStatement.addBatch();
        }
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void insertProfileData(Connection connection, Profile profile, ProfileConfig profileConfig) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into profile values (nextval('profile_id_seq'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,true,?,?,?,?,?,?)");
        preparedStatement.setString(1, (profile.firstName.toLowerCase() + "-" + profile.lastName.toLowerCase()));
        preparedStatement.setString(2, profile.firstName);
        preparedStatement.setString(3, profile.lastName);
        preparedStatement.setString(4, generateEmail(profile));
        preparedStatement.setString(5, SITIES[r.nextInt(SITIES.length)]);
        preparedStatement.setString(6, COUNTRY);
        birthDay = randomBirthDay();
        preparedStatement.setDate(7, Date.valueOf(birthDay));
        preparedStatement.setString(8, generatePhone());
        preparedStatement.setString(9, profileConfig.objective);
        preparedStatement.setString(10, profileConfig.summary);
        String uid = UUID.randomUUID() + ".jpg";
        File largePhoto = new File(MEDIA_DIR + "/avatar/" + uid);
        if (!largePhoto.getParentFile().exists()) {
            largePhoto.getParentFile().mkdirs();
        }
        Files.copy(Paths.get(profile.photo), Paths.get(largePhoto.getAbsolutePath()));
        preparedStatement.setString(11, "/media/avatar/" + uid);
        String smallUid = uid.replace(".jpg", "-small.jpg");
        Thumbnails.of(largePhoto).size(200, 200).toFile(new File(MEDIA_DIR + "/avatar/" + smallUid));
        preparedStatement.setString(12, "/media/avatar/" + smallUid);
        if (r.nextBoolean()) {
            preparedStatement.setString(13, getInfo());
        } else {
            preparedStatement.setNull(13, Types.VARCHAR);
        }
        preparedStatement.setString(14, PASSWORD_HASH);
        preparedStatement.setDate(15, new java.sql.Date(System.currentTimeMillis()));
        if (r.nextBoolean()) {
            preparedStatement.setString(16, "facebook.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
        } else {
            preparedStatement.setNull(16, Types.VARCHAR);
        }
        if (r.nextBoolean()) {
            preparedStatement.setString(17, (profile.firstName + "-" + profile.lastName).toLowerCase());
        } else {
            preparedStatement.setNull(17, Types.VARCHAR);
        }
        if (r.nextBoolean()) {
            preparedStatement.setString(18, "linkedin.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
        } else {
            preparedStatement.setNull(18, Types.VARCHAR);
        }
        if (r.nextBoolean()) {
            preparedStatement.setString(19, "stackoverflow.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
        } else {
            preparedStatement.setNull(19, Types.VARCHAR);
        }
        if (r.nextBoolean()) {
            preparedStatement.setString(20, "github.com/" + (profile.firstName + "-" + profile.lastName).toLowerCase());
        } else {
            preparedStatement.setNull(20, Types.VARCHAR);
        }

        preparedStatement.executeUpdate();
        preparedStatement.close();
        idProfile++;
    }

    private static LocalDate randomBirthDay() {
        return LocalDate.of((1990 + r.nextInt(10)), r.nextInt(11) + 1, r.nextInt(29) + 1);
    }

    private static String generatePhone() {
        StringBuilder phone = new StringBuilder("+38095");
        for (int i = 0; i < 7; i++) {
            int nextInt = r.nextInt(9);
            phone.append(nextInt);
        }
        return phone.toString();
    }

    private static String generateEmail(Profile profile) {
        String email = profile.firstName.toLowerCase() + profile.lastName.toLowerCase() + "@gmail.com";
        return email;
    }

    private static String getInfo() {
        int endIndex = r.nextInt(SENTENCES.size());
        int startIndex = r.nextInt(endIndex);
        if (endIndex - startIndex > 4) {
            endIndex = startIndex + 3;
        }
        return StringUtils.join(SENTENCES.subList(startIndex, endIndex), " ");
    }

    private static final class Profile {
        private final String firstName;
        private final String lastName;
        private final String photo;

        public Profile(String firstName, String lastName, String photo) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.photo = photo;
        }

        @Override
        public String toString() {
            return String.format("Profile [firstName = %s, lastName = %s]", firstName, lastName);
        }
    }

    private static final class Certificate {
        private final String name;
        private final String largeImg;

        public Certificate(String name, String largeImg) {
            this.name = name;
            this.largeImg = largeImg;
        }
    }

    private static final class ProfileConfig {
        private final String objective;
        private final String summary;
        private final Course[] courses;
        private final int certificates;

        private ProfileConfig(String objective, String summary, Course[] courses, int certificates) {
            super();
            this.objective = objective;
            this.summary = summary;
            this.courses = courses;
            this.certificates = certificates;
        }
    }

    private static final class Course {
        private final String name;
        private final String company;
        private final String github;
        private final String responsibilities;
        private final String demo;
        private final Map<String, Set<String>> skills;

        private Course(String name, String company, String github, String responsibilities, String demo, Map<String, Set<String>> skills) {
            super();
            this.name = name;
            this.company = company;
            this.github = github;
            this.responsibilities = responsibilities;
            this.demo = demo;
            this.skills = skills;
        }

        private static Map<String, Set<String>> createSkillMap() {
            Map<String, Set<String>> skills = new LinkedHashMap<>();
            skills.put("Languages", new LinkedHashSet<String>());
            skills.put("DBMS", new LinkedHashSet<String>());
            skills.put("Web", new LinkedHashSet<String>());
            skills.put("Java", new LinkedHashSet<String>());
            skills.put("IDE", new LinkedHashSet<String>());
            skills.put("CVS", new LinkedHashSet<String>());
            skills.put("Web Servers", new LinkedHashSet<String>());
            skills.put("Build system", new LinkedHashSet<String>());
            skills.put("Cloud", new LinkedHashSet<String>());
            return skills;
        }

        static Course createCoreCourse() {
            Map<String, Set<String>> skills = createSkillMap();
            skills.get("Languages").add("Java");

            skills.get("DBMS").add("Mysql");

            skills.get("Java").add("Threads");
            skills.get("Java").add("IO");
            skills.get("Java").add("JAXB");
            skills.get("Java").add("GSON");

            skills.get("IDE").add("Eclipse for JEE Developer");

            skills.get("CVS").add("Git");
            skills.get("CVS").add("Github");

            skills.get("Build system").add("Maven");

            return new Course("Java Core Course", "DevStudy.net", null, "Developing the java console application which imports XML, JSON, Properties, CVS to Db via JDBC", null, skills);
        }

        static Course createBaseCourse() {
            Map<String, Set<String>> skills = createSkillMap();
            skills.get("Languages").add("Java");
            skills.get("Languages").add("SQL");

            skills.get("DBMS").add("Postgresql");

            skills.get("Web").add("HTML");
            skills.get("Web").add("CSS");
            skills.get("Web").add("JS");
            skills.get("Web").add("JS");
            skills.get("Web").add("Foundation");
            skills.get("Web").add("JQuery");

            skills.get("Java").add("Servlets");
            skills.get("Java").add("Logback");
            skills.get("Java").add("JSP");
            skills.get("Java").add("JSTL");
            skills.get("Java").add("JDBC");
            skills.get("Java").add("Apache Commons");
            skills.get("Java").add("Google+ Social API");

            skills.get("IDE").add("Eclipse for JEE Developer");

            skills.get("CVS").add("Git");
            skills.get("CVS").add("Github");

            skills.get("Web Servers").add("Tomcat");

            skills.get("Build system").add("Maven");

            skills.get("Cloud").add("OpenShift");

            return new Course("Java Base Course", "DevStudy.net", "https://github.com/TODO",
                    "Developing the web application 'blog' using free HTML template, downloaded from intenet. Populating database by test data and uploading web project to OpenShift free hosting",
                    "http://LINK_TO_DEMO_SITE", skills);
        }

        static Course createAdvancedCourse() {
            Map<String, Set<String>> skills = createSkillMap();
            skills.get("Languages").add("Java");
            skills.get("Languages").add("SQL");
            skills.get("Languages").add("PLSQL");

            skills.get("DBMS").add("Postgresql");

            skills.get("Web").add("HTML");
            skills.get("Web").add("CSS");
            skills.get("Web").add("JS");
            skills.get("Web").add("JS");
            skills.get("Web").add("Bootstrap");
            skills.get("Web").add("JQuery");

            skills.get("Java").add("Spring MVC");
            skills.get("Java").add("Logback");
            skills.get("Java").add("JSP");
            skills.get("Java").add("JSTL");
            skills.get("Java").add("Spring Data JPA");
            skills.get("Java").add("Apache Commons");
            skills.get("Java").add("Spring Security");
            skills.get("Java").add("Hibernate JPA");
            skills.get("Java").add("Facebook Social API");

            skills.get("IDE").add("Eclipse for JEE Developer");

            skills.get("CVS").add("Git");
            skills.get("CVS").add("Github");

            skills.get("Web Servers").add("Tomcat");
            skills.get("Web Servers").add("Nginx");

            skills.get("Build system").add("Maven");

            skills.get("Cloud").add("AWS");

            return new Course("Java Advanced Course", "DevStudy.net", "https://github.com/TODO",
                    "Developing the web application 'online-resume' using bootstrap HTML template, downloaded from intenet. Populating database by test data and uploading web project to AWS EC2 instance",
                    "http://LINK_TO_DEMO_SITE", skills);
        }
    }
}
