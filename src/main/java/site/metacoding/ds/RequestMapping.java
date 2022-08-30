package site.metacoding.ds;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 메서드, 클래스, 필드(변수)
@Retention(RetentionPolicy.RUNTIME) //RUNTIME(런타임시), SOURCE(컴파일시)
public @interface RequestMapping {
	String value(); // value메서드 고정, 키값(value로 고정되어 있다.)
}
