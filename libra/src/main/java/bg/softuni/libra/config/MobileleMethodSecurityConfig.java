package bg.softuni.libra.config;

import bg.softuni.libra.service.BookService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MobileleMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    private final BookService bookService;

    public MobileleMethodSecurityConfig(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return new MobileleSecurityExpressionHandler(bookService);
    }
    }
