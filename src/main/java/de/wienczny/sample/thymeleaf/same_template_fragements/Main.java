package de.wienczny.sample.thymeleaf.same_template_fragements;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Collections;
import java.util.Locale;

/**
 * Thymeleaf same template fragment example showing semantic changes between thymeleaf 2.x and 3.x.
 * The templates used by this example worked with 2.x. In 3.x the fragments from the first template
 * "test.html" are NOT available in "template.html".
 */
public class Main {
    public static void main(final String[] args) {
        /* Init template resolver */
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");

        /* Init template engine */
        final TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        /* Prepare context */
        final IContext iContext = new Context(Locale.getDefault());

        /* Prepare template spec */
        final TemplateSpec templateSpec = new TemplateSpec("test", Collections.emptyMap());

        /* Process template */
        final String result = templateEngine.process(templateSpec, iContext);

        /* Print processed template */
        System.out.println(result);
    }
}
