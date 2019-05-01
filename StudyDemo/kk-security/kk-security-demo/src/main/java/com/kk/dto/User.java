package com.kk.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.kk.myAnotation.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class User {

    public interface UserSimpleView {
    }

    public interface UserDetailView extends UserSimpleView {
    }

    @JsonView(UserSimpleView.class)
    private Integer id;

    @JsonView(UserSimpleView.class)
    @NotEmpty(message = "姓名为空 请查看")
    private String name;

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "不能为男 也不能为女")
    private String sex;

    @JsonView(UserDetailView.class)
    private Integer age;

}
