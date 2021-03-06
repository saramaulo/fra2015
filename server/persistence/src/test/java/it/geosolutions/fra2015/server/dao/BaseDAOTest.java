/*
 *  Copyright (C) 2007 - 2011 GeoSolutions S.A.S.
 *  http://www.geo-solutions.it
 *
 *  GPLv3 + Classpath exception
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.geosolutions.fra2015.server.dao;

import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class BaseDAOTest
 *
 * @author ETj (etj at geo-solutions.it)
 * @author Tobia di Pisa (tobia.dipisa at geo-solutions.it)
 */
public abstract class BaseDAOTest extends TestCase {

    protected final static Logger log = Logger.getLogger(BaseDAOTest.class);

    protected static UserDAO userDAO;
    protected static EntryDAO entryDAO;

    protected static ClassPathXmlApplicationContext ctx = null;

    public BaseDAOTest() {

        synchronized (BaseDAOTest.class) {
            if (ctx == null) {
                String[] paths = {
                    "applicationContext.xml"
                };
                ctx = new ClassPathXmlApplicationContext(paths);

                userDAO = (UserDAO) ctx.getBean("userDAO");
                entryDAO = (EntryDAO) ctx.getBean("entryDAO");
            }
        }
    }

    @Override
    protected void setUp() throws Exception {
        StringBuilder sb = new StringBuilder();

        sb.append("Setup ").append(getClass().getSimpleName()).append("::").append(getName()).append("...");

        try {
            super.setUp();
            sb.append("DONE");
        } catch (Exception ex) {
            sb.append("FAILED:").append(ex);
            throw ex;
        } finally {
            log.info(sb.toString());
        }
    }

    @Override
    protected void runTest() throws Throwable {

        StringBuilder sb = new StringBuilder();

        sb.append("[").append(this.getName()).append("] Start");

        log.info(sb.toString());

        try {
            super.runTest();
        } catch (Exception ex) {
            throw ex;
        } finally {
            sb = new StringBuilder();
            sb.append("[").append(this.getName()).append("] End");
            log.info(sb.toString());
        }

    }

    // @Test
    public void testCheckDAOs() {
        assertNotNull(userDAO);
    }
}
