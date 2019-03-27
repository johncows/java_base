package com.kk.valid;


import com.kk.myAnotation.MyConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {



   @Override
   public void initialize(MyConstraint myConstraint) {
      System.out.println("该校验器已被初始化");
   }

   @Override
   public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
      System.out.println("constraintValidatorContext = " + constraintValidatorContext);
      System.out.println("o = " + o);
      return false;
   }
}
