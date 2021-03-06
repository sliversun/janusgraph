// Copyright 2017 JanusGraph Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.janusgraph.diskstorage.solr;

import org.janusgraph.graphdb.JanusGraphIndexTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Matthias Broecheler (me@matthiasb.com)
 */
public abstract class SolrJanusGraphIndexTest extends JanusGraphIndexTest {

    @BeforeClass
    public static void setUpMiniCluster() throws Exception {
        SolrRunner.start();
    }

    @AfterClass
    public static void tearDownMiniCluster() throws Exception {
        SolrRunner.stop();
    }


    protected SolrJanusGraphIndexTest() {
        super(true, true, true);
    }

    @Override
    public boolean supportsLuceneStyleQueries() {
        return true;
    }

    @Override
    protected boolean supportsCollections() {
        return false;
    }

    @Test
    public void testRawQueries() {
        clopen(option(SolrIndex.DYNAMIC_FIELDS,JanusGraphIndexTest.INDEX),false);
        super.testRawQueries();
    }

}
