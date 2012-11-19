package it.pkg;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
@RunWith(JUnitReportingRunner.class)

public class TableStory extends JUnitStories {
	
	
	public TableStory(){
		configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
        .doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(60);
	}
	
	
	public Configuration configuration(){
		//return new MostUsefulConfiguration().usePendingStepStrategy(new FailingUponPendingStep());
		//JUnitReportingRunner.recommandedControls(configuredEmbedder());
		Class<? extends Embeddable> embeddableClass = this.getClass();
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");
		return new MostUsefulConfiguration()
			.useStoryLoader(new LoadFromClasspath(embeddableClass))
			.usePendingStepStrategy(new FailingUponPendingStep())
			.useStoryReporterBuilder(new StoryReporterBuilder()
				.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
				.withDefaultFormats()
				.withViewResources(viewResources)
				.withFormats(HTML,CONSOLE,XML,TXT))
				.useStepMonitor(new SilentStepMonitor());		
	}
	
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new TableStorySteps());
	}

	
	@Override
	protected List<String> storyPaths() {
		// TODO Auto-generated method stub
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/table_story.story"), null);
	}
}
