package org.openstreetmap.atlas.checks.validation.linear.edges;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openstreetmap.atlas.checks.configuration.ConfigurationResolver;
import org.openstreetmap.atlas.checks.validation.verifier.ConsumerBasedExpectedCheckVerifier;

/**
 * Tests for {@link RoundaboutHighwayTagCheck}
 * 
 * @author mselaineleong
 */
public class RoundaboutHighwayTagCheckTest
{
    @Rule
    public RoundaboutHighwayTagCheckTestRule setup = new RoundaboutHighwayTagCheckTestRule();

    @Rule
    public ConsumerBasedExpectedCheckVerifier verifier = new ConsumerBasedExpectedCheckVerifier();

    @Test
    public void roundaboutWithHighwayTagFiveTest()
    {
        this.verifier.actual(this.setup.roundaboutWithHighwayTagFiveAtlas(),
                new RoundaboutHighwayTagCheck(ConfigurationResolver.emptyConfiguration()));
        this.verifier.globallyVerify(flags -> Assert.assertEquals(1, flags.size()));
    }

    @Test
    public void roundaboutWithHighwayTagOneTest()
    {
        this.verifier.actual(this.setup.roundaboutWithHighwayTagOneAtlas(),
                new RoundaboutHighwayTagCheck(ConfigurationResolver.emptyConfiguration()));
        this.verifier.globallyVerify(flags -> Assert.assertEquals(0, flags.size()));
    }

    @Test
    public void roundaboutWithHighwayTagThreeTest()
    {
        this.verifier.actual(this.setup.roundaboutWithHighwayTagThreeAtlas(),
                new RoundaboutHighwayTagCheck(ConfigurationResolver.emptyConfiguration()));
        this.verifier.globallyVerify(flags -> Assert.assertEquals(0, flags.size()));
    }

    @Test
    public void roundaboutWithHighwayTagTwoTest()
    {
        this.verifier.actual(this.setup.roundaboutWithHighwayTagTwoAtlas(),
                new RoundaboutHighwayTagCheck(ConfigurationResolver.emptyConfiguration()));
        this.verifier.globallyVerify(flags -> Assert.assertEquals(1, flags.size()));
    }

    @Test
    public void roundaboutWithHighwayTagZeroTest()
    {
        this.verifier.actual(this.setup.roundaboutWithHighwayTagZeroAtlas(),
                new RoundaboutHighwayTagCheck(ConfigurationResolver.emptyConfiguration()));
        this.verifier.globallyVerify(flags -> Assert.assertEquals(0, flags.size()));
    }
}