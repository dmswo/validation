package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject(){
        String[] messagesCodes = codesResolver.resolveMessageCodes("required", "item");
        Assertions.assertThat(messagesCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messagesCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        for (String messagesCode : messagesCodes) {
            System.out.println("messagesCode = " + messagesCode);
        }
        Assertions.assertThat(messagesCodes).containsExactly(
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
                );
    }
}
