package jvm;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementScanner6;
import java.util.Set;

/**
 * Created by CS on 2017/11/23.
 */
@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class NameCheckerProcesser extends AbstractProcessor {
    private NameChecker checker;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        checker = new NameChecker(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements()) {
                checker.checkNames(element);
            }
        }
        return false;
    }

}

class NameChecker {
    private final Messager messager;
    NameScanner scanner = new NameScanner();
    public NameChecker(ProcessingEnvironment processingEnvironment) {
        this.messager = processingEnvironment.getMessager();
    }

    public void checkNames(Element element) {
        scanner.scan(element);
    }

    private class NameScanner extends ElementScanner6<Void, Void> {
        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD) {
                System.out.println(e.getSimpleName());
            }
            return super.visitExecutable(e, aVoid);
        }
    }
}