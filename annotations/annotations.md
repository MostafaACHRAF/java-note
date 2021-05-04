# Annotations
- Annotations are a metadata, they don't affect the operation of the class.
- They are used on declarations: field, method, class, other elements...
- There some annotations who are used on annotations, like: @Documented, @Retention, @Target, @Inherited, @Repeatable
- Normally annotations are used on declarations only, but since Java SE 8, we could use annotation on types, which in every place where we declare types, like 'new' operatior, 'throws' clause, 'field type', cast... 

## @Retention
- This annotation indicate the scope of the annotation we are about to define:
1- RetentionPolicy.SOURCE: Available only at the level of the source code and ignored by the compiler<br/>
2- RetentionPolicy.CLASS: Available at compile time, but ignored by the JVM<br/>
3- RetentionPolicy.RUNTIME: Kept tell the runtime to be used later!<br/>

## @Target
- Restricts what type of element the annotation can applied to: field, class, method,...
- ElementType.ANNOTATION_TYPE: can be applied to an annotation type
- ElementType.CONSTRUCTOR: can be applied to a constructor
- ElementType.LOCAL_VARIABLE: can be applied to a local variable
- ElementType.FIELD: can be applied to a field or property
- ElementType.METHOD: can be applied to a method declaration
- ElementType.PACKAGE: can be applied to a package declaration
- ElementType.PARAMETER: can be applied to a method's parameter
- ElementType.TYPE: can be applied to any element of a class

## @Inherited
- Indicates that this annotation can be inherited from the super class
- By default you can't inherit the annotations of a super class

## @Repeatable
- Indicates that this annotation can be placed more than once on the target element's declaration

- The value used as a 'default' value for an annotation type's element must be a constant: int i = Integer.valueOf(5); int value() default i; // this code won't compile
- You don't have to specify annotation type's target and retention policy.
- According to my experiments, by default you can use your annotation with any element(class, method, field,...) 
- You can't create  methods, nor static, nor default, nod private. 