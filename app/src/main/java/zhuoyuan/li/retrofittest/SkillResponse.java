package zhuoyuan.li.retrofittest;

import java.util.List;

public class SkillResponse {

    private List<Skill> data;
    private int code;

    List<Skill> getData() {
        return data;
    }

    public void setData(List<Skill> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public class Skill {
        private String name;
        private String type;
        private String desc;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "Skill{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", desc='" + desc + '\'' +
                    '}';
        }
    }
}
