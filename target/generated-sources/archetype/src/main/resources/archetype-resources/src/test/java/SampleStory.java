#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;
import org.jbehave.core.steps.SilentStepMonitor;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;


//@ContextConfiguration(locations = "classpath:OrderPersistenceTests-context.xml")
@RunWith(JUnitReportingRunner.class)
public class SampleStory extends JUnitStories 
{
	
	public SampleStory(){
		configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
        .doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(60);
	}
	
	/* @Override
	    public Configuration configuration() {
	        Class<? extends Embeddable> embeddableClass = this.getClass();
	        // Start from default ParameterConverters instance
	        ParameterConverters parameterConverters = new ParameterConverters();
	        // factory to allow parameter conversion and loading from external resources (used by StoryParser too)
	        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters);
	        // add custom converters
	        parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
	                new ExamplesTableConverter(examplesTableFactory));
	        return new MostUsefulConfiguration()
	            .useStoryLoader(new LoadFromClasspath(embeddableClass))
	            .useStoryParser(new RegexStoryParser(examplesTableFactory)) 
	            .useStoryReporterBuilder(new StoryReporterBuilder()
	                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
	                .withDefaultFormats()
	                .withFormats(CONSOLE, TXT, HTML, XML))
	            .useParameterConverters(parameterConverters);
	    }*/
	
	
	public Configuration configuration(){
		//return new MostUsefulConfiguration().usePendingStepStrategy(new FailingUponPendingStep());
		//JUnitReportingRunner.recommandedControls(configuredEmbedder());
		Class<? extends Embeddable> embeddableClass = this.getClass();
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");
		return new MostUsefulConfiguration()
			.useStoryLoader(new LoadFromClasspath(embeddableClass))
			//.usePendingStepStrategy(new FailingUponPendingStep())
			.useStoryReporterBuilder(new StoryReporterBuilder()
				.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
				.withDefaultFormats()
				.withViewResources(viewResources)
				.withFormats(HTML,CONSOLE,XML,TXT))
			.useParameterConverters(new ParameterConverters()
			//.addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")))
				.addConverters(customConverters()))
				.useStepMonitor(new SilentStepMonitor());
		
	}
	
	private ParameterConverter[] customConverters(){
		List<ParameterConverter> converters = new ArrayList<ParameterConverter>();
		converters.add(new CarConverter());
		return converters.toArray(new ParameterConverter[converters.size()]);
	}
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new SampleStorySteps());
	}

	
	@Override
	protected List<String> storyPaths() {
		// TODO Auto-generated method stub
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), null);
	}
	
}
