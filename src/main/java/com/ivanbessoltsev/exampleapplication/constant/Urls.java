package com.ivanbessoltsev.exampleapplication.constant;


public interface Urls {
    String NAME = "api";
    String VERSION = "v1";
    String FULL = NAME + "/" + VERSION;

    interface User {
        String PART = "user";
        String FULL = Urls.FULL + "/" + PART;

        interface All {
            String PART = "all";
            String FULL = Urls.User.FULL + "/" + PART;
        }

        interface Id {
            String PART = "{id}";
            String FULL = Urls.User.FULL + "/" + PART;
        }
    }

    interface Contact {
        String PART = "contact";
        String FULL = Urls.FULL + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = Urls.Contact.FULL + "/" + PART;
        }
    }

    interface City {
        String PART = "city";
        String FULL = Urls.FULL + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = Urls.City.FULL + "/" + PART;
        }
    }

    interface Department {
        String PART = "department";
        String FULL = Urls.FULL + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = Urls.Department.FULL + "/" + PART;
        }
    }

    interface FamilyMember {
        String PART = "familyMember";
        String FULL = Urls.FULL + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = Urls.FamilyMember.FULL + "/" + PART;
        }
    }

    interface Transport {
        String PART = "transport";
        String FULL = Urls.FULL + "/" + PART;

        interface Age {
            String PART = "{age}";
            String FULL = Urls.Transport.FULL + "/" + PART;
        }
    }

    interface Photo {
        String PART = "photo";
        String FULL = Urls.FULL + "/" + PART;

        interface Id {
            String PART = "{id}";
            String FULL = Urls.Photo.FULL + "/" + PART;
        }
    }

    interface Dashboard {
        String PART = "dashboard";
        String FULL = Urls.FULL + "/" + PART;

        interface CountUsersByDepartment {
            String PART = "countUserByDepartment";
            String FULL = Urls.Dashboard.FULL + "/" + PART;
        }

        interface CountUsersByCity {
            String PART = "countUserByCity";
            String FULL = Urls.Dashboard.FULL + "/" + PART;
        }
    }

}
