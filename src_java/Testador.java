import java.lang.reflect.Field;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;

import valueObjects.alu.Alu_AlunoVO;


public class Testador {
	public static void main(String[] args) {
        Testador.testar(new Alu_AlunoVO());
    }
    public static void testar(Object obj) {
        Class classe = obj.getClass();
        System.out.println("-------------Inicio dos Testes--------------");
        Field[] fields = classe.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Select.class)) {
                field.setAccessible(true);
                System.out.println(field.getName());
            }
        }
        System.out.println("---------------Fim dos Testes---------------");

    }
}
