package bg.softuni.libra.config;

import bg.softuni.libra.service.BookService;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;


public class OwnerSecurityExpressionRoot
        extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {

    private final Authentication authentication;
    private final BookService bookService;
    private Object filterObject;
    private Object returnObject;

    public OwnerSecurityExpressionRoot(Authentication authentication,
                                       BookService bookService) {
        super(authentication);
        this.authentication = authentication;
        this.bookService = bookService;
    }

    public boolean isOwner(Long id) {
        if (authentication.getPrincipal() == null) {
            return false;
        }

        var userName = authentication.getName();

        return bookService.isOwner(userName, id);
    }


    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
      this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return this.returnObject;
    }

    @Override
    public Object getThis() {
        return this;
    }
}
