package com.mohibur.leetcode.interfaces;

public interface UrlConstant {
    String ID = "/{id}";
    String API = "/api";
    String VERSION1 = "/v1";

    // common module
    class UserUrl {
        public static final String USER = "/users";
        public static final String REGISTER = USER + "/register";
        public static final String VERIFY = USER +  "/verify";
        public static final String LOGIN = USER +  "/login";
        public static final String LOGOUT = API + USER +  "/logout";
        public static final String GET = API + USER;
    }

    class RoleUrl {
        public static final String ROLE = "/roles";
        public static final String ROOT = API + VERSION1 + ROLE;
        public static final String GET = API + VERSION1 + ROLE + ID;
    }

    // discussion module
    class CommentUrl {
        public static final String COMMENT = "/comments";
        public static final String ROOT = API + VERSION1 + COMMENT;
        public static final String GET = API + VERSION1 + COMMENT + ID;
    }

    class DiscussUrl {
        public static final String DISCUSS = "/discusses";
        public static final String ROOT = API + VERSION1 + DISCUSS;
        public static final String GET = API + VERSION1 + DISCUSS + ID;
    }

    // problem solving module
    class ConstraintUrl {
        public static final String CONSTRAINT = "/constraints";
        public static final String ROOT = API + VERSION1 + CONSTRAINT;
        public static final String GET = API + VERSION1 + CONSTRAINT + ID;
    }

    class ExampleUrl {
        public static final String EXAMPLE = "/examples";
        public static final String ROOT = API + VERSION1 + EXAMPLE;
        public static final String GET = API + VERSION1 + EXAMPLE + ID;
    }

    class HintUrl {
        public static final String HINT = "/hints";
        public static final String ROOT = API + VERSION1 + HINT;
        public static final String GET = API + VERSION1 + HINT + ID;
    }

    class ProblemUrl {
        public static final String PROBLEM = "/problems";
        public static final String ROOT = API + VERSION1 + PROBLEM;
        public static final String GET = API + VERSION1 + PROBLEM + ID;
    }

    class SolutionCodeUrl {
        public static final String SOLUTION_CODE = "/solution-codes";
        public static final String ROOT = API + VERSION1 + SOLUTION_CODE;
        public static final String GET = API + VERSION1 + SOLUTION_CODE + ID;
    }

    class SolutionUrl {
        public static final String SOLUTION = "/solutions";
        public static final String ROOT = API + VERSION1 + SOLUTION;
        public static final String GET = API + VERSION1 + SOLUTION + ID;
    }

    class SubmissionUrl {
        public static final String SUBMISSION = "/submissions";
        public static final String ROOT = API + VERSION1 + SUBMISSION;
        public static final String GET = API + VERSION1 + SUBMISSION + ID;
    }

    class TagUrl {
        public static final String TAG = "/tags";
        public static final String ROOT = API + VERSION1 + TAG;
        public static final String GET = API + VERSION1 + TAG + ID;
    }

    class TopicUrl {
        public static final String TOPIC = "/topics";
        public static final String ROOT = API + VERSION1 + TOPIC;
        public static final String GET = API + VERSION1 + TOPIC + ID;
        public static final String TOPIC_WISE_PROBLEM_COUNT = "/getTopicWiseProblemCount";
    }
}
